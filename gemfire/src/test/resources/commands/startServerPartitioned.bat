@echo on

setlocal

rmdir E:\workspace\gemfire\service\locators\* /s /q
rmdir E:\workspace\gemfire\service\servers\ /s /q

@rem 
gfsh -e "start locator --name=locator1 --port=41111 --initial-heap=50m --max-heap=50m --dir='E:\workspace\gemfire\service\locators\locator1' --mcast-port=0" ^
-e "start server --name=server1 --locators=localhost[41111] --server-port=41122 --dir='E:\workspace\gemfire\service\servers\server1' --initial-heap=50m --max-heap=50m --cache-xml-file='E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml' --J=-XX:+UseConcMarkSweepGC --J=-XX:CMSInitiatingOccupancyFraction=60" ^
-e "start server --name=server2 --locators=localhost[41111] --server-port=41123 --dir='E:\workspace\gemfire\service\servers\server2' --initial-heap=50m --max-heap=50m --cache-xml-file='E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml' --J=-XX:+UseConcMarkSweepGC --J=-XX:CMSInitiatingOccupancyFraction=60" ^
-e "start server --name=server3 --locators=localhost[41111] --server-port=41124 --dir='E:\workspace\gemfire\service\servers\server3' --initial-heap=50m --max-heap=50m --cache-xml-file='E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml' --J=-XX:+UseConcMarkSweepGC --J=-XX:CMSInitiatingOccupancyFraction=60"

@rem 
gfsh -e "deploy --jar=E:\workspace\eclipse\java\gemfire\target\gemfire.jar" ^
-e "list deployed"

@rem 
gfsh -e "connect --locator=localhost[41111]" ^
-e "list members" ^
-e "query --query='select * from /Customer'" ^
-e "query --query='select * from /BookOrder'" ^
-e "query --query='select * from /BookOrderItem'"


@rem 
gfsh -e "connect --locator=localhost[41111]" ^
-e start pulse

gfsh -e "connect --locator=localhost[41111]" ^
-e "shutdown --include-locators=true"


gfsh start locator --name=locator1 --port=41111 --initial-heap=50m --max-heap=50m --dir="E:\workspace\gemfire\service\locators\locator1" --mcast-port=0

gfsh connect --locator=localhost[41111]

@rem Required for Use pdx serialization other than Java Serialization

gfsh configure pdx --auto-serializable-classes=com\.practice\.nosql\.gemfire\..*

gfsh start server --name=server1 --locators=localhost[41111] --server-port=41122 --dir="E:\workspace\gemfire\service\servers\server1" --initial-heap=50m --max-heap=50m --cache-xml-file="E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml"

gfsh start server --name=server2 --locators=localhost[41111] --server-port=41123 --dir="E:\workspace\gemfire\service\servers\server2" --initial-heap=50m --max-heap=50m --cache-xml-file="E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml"

gfsh start server --name=server3 --locators=localhost[41111] --server-port=41124 --dir="E:\workspace\gemfire\service\servers\server3" --initial-heap=50m --max-heap=50m --cache-xml-file="E:\workspace\eclipse\java\gemfire\src\main\resources\commands\server-cache-partitioned.xml"

gfsh create region --name=Customer --type=PARTITION
gfsh create region --name=Product --type=REPLICATE

gfsh put --key=1 --value="Rajiv Chaudhuri" --region=Customer
gfsh put --key=2 --value="Mahika Chaudhuri" --region=Customer
gfsh put --key=3 --value="Tithi Bose" --region=Customer

gfsh put --key=1 --value="Cell Phone" --region=Product
gfsh put --key=2 --value="Toys" --region=Product
gfsh put --key=3 --value="Grocery" --region=Product

gfsh list region 

gfsh query --query="select * from /Customer"
gfsh query --query="select * from /Product"

gfsh stop server --name=server1

@rem Still all Customer is available as redundant-copies at least 1
gfsh query --query="select * from /Customer"

@rem Should Failue Occurs as Product scope is global- But not Why?
gfsh put --key=4 --value="Opps" --region=Product

gfsh shutdown --include-locators=true

gfsh show metrics --member=server1 --region=Customer --categories=partition

goto end

:end