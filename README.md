# api_worker_monitor
api_worker_monitor
Provide restful API to get worker status, the result is in json format.

table definition is in the following file:
https://github.com/Dora2021Chen/api_worker_monitor/tree/main/scripts/createTable.sql

test script using python is in the following file:
https://github.com/Dora2021Chen/api_worker_monitor/tree/main/scripts/test.py
after running this test script, the test result file will be generated in the same direction as the test.py file, with name testResult.txt

When running in IDE, or the target folder, the result will be saved in workerStatus.csv, in the same folder as src, target

When running outside the project source folder, the result will be saved in workerStatus.csv, in the same folder as the jar file

At the same time, the result will be saved into database

The API server uses default port 8080, uses MySQL database on localhost, with port 3306, and the database name is worker_monitor

The Swagger web page is: http://localhost:8080/swagger-ui.html#

the request url is as follows: http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_1

the result is in the following format

ResponseRows {

        public integer($int32)      statusCode;  //0:succeed, >=1000:fail

        public string               statusMsg;

        public List<WorkerModel>    entities;
    
}


WorkerModel{

      id                integer($int64)

      createAt          integer($int64)

      accessCode        integer($int32)

      workerId          integer($int32)

      cpuUsage          string

      gpuUsage          string

      ramUsage          string

      vmemUsage         string

      workerName        string
  
}
