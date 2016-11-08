package com.moilion.circle.release.r039

import java.io.{File, PrintWriter}
import java.nio.file.Files

import org.jsoup.Jsoup
import java.util
import java.util.concurrent.atomic.AtomicInteger

import org.jsoup.nodes.{Document, Element}

import scala.io.Source

/**
  * Created by trydofor on 6/17/16.
  */
object ChinaArea extends App {

  case class Parser(selector:String, parse:util.Iterator[_<:Element] =>(String,String,String))



  def spider(url:String, parsers:List[Parser],output:PrintWriter):Unit = {
    parsers match {
      case parser::tail =>
        val doc = jsoup(url)
        val iter = doc.select(parser.selector).iterator()
        while (iter.hasNext) {
          val (code,name,href) = parser.parse(iter)
          output.println(s"($code,'$name'),")
          output.flush()
          val pos = url.lastIndexOf("/")
          val base = url.substring(0,pos)
          spider(s"$base/$href",tail,output)
        }
      case Nil =>
    }
  }

  val data = "/home/trydofor/workspace/moilion-com/moilioncircle.product/release/2016-033/039/data"
  val cache = s"$data/cache"
  val charset = "gbk"
  val count = new AtomicInteger(1)
  def jsoup(url:String):Document={
    println(s"${count.getAndIncrement()} $url")
    val key = url.replaceAll("[:/]","_")
    val file = new File(s"$cache/$key")
    if(!file.exists()){
      Thread.sleep(3000)
      val html = Source.fromURL(url, charset).getLines().mkString("\n")
      Files.write(file.toPath,html.getBytes(charset))
    }
    val doc = Jsoup.parse(file, charset)
    doc
  }

  val province = Parser(".provincetr a", iter =>{
    val element = iter.next()
    val href = element.attr("href")
    val code = href.substring(0, 2)
    val name = element.text()
    (code+"0000000000",name,href)
  })
  val city = Parser(".citytr a", iter =>{
    val element = iter.next()
    val href = element.attr("href")
    val code = element.text()
    val name = iter.next().text()
    (code,name,href)
  })
  val county = Parser(".countytr a", iter =>{
    val element = iter.next()
    val href = element.attr("href")
    val code = element.text()
    val name = iter.next().text()
    (code,name,href)
  })
  val town = Parser(".towntr a", iter =>{
    val element = iter.next()
    val href = element.attr("href")
    val code = element.text()
    val name = iter.next().text()
    (code,name,href)
  })
  val village = Parser(".villagetr td", iter =>{
    val element = iter.next()
    val code = element.text()
    iter.next()
    val name = iter.next().text()
    (code,name,"")
  })

  val index = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2014/index.html"
  val output = new PrintWriter(s"$data/output.txt")

  val parses = List(province,city,county,town,village)
  spider(index,parses,output)
  output.close()
}
