find idcard -name '*.jpg' | \
parallel composite -gravity center -dissolve 20 watermark.png {} {//}/id{/}