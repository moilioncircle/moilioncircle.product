【我】
anorm.SqlParser._ 已经不纯洁了，比起spring jdbctemplate，今天坑了我一下。
有个别人定义的字段 mysql tinyint(1)，anorm按Boolean取值，但纯jdbc还是int
结果就是，boolean只有0和1，jdbc取出来，可以是-128～127

【福】
``` scala
DB.withConnection { implicit conn =>
  val query = SQL"select * from csw_feedback_track as f left outer join csw_feedback_reply as r on f.uuid = r.feedback_id where  (r.feedback_id is null) and (f.cascaded_reply = 0) order by f.createTime desc limit $offset,$count"
  val rs = query.executeQuery().resultSet

  val feedbacks = new ListBuffer[Feedback]
  while (rs.next()) {
    val feedback = Feedback(rs.getLong(1), rs.getLong(2), rs.getString(3), rs.getString(4), rs.getLong(5))
    feedbacks.append(feedback)
  }
  feedbacks
}
``` 
