#pip install requests   #using this command to install requests first in OS command window.

import requests,pprint
import sys
from datetime import datetime

sys.stdout=open("testResult.txt","w")

def check(url, expectedResultCode):
    print();
    print(url);
    res = requests.get(url);
    resBody = res.json();
    
    print(resBody);

    if (resBody['statusCode'] == expectedResultCode):
        print("pass");
    else:
        print("fail");
        
url="http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_1111111111111111111111111111111111111111111111111111111111111111111";
check(url,1004);

url="http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=";
check(url,1003);

url="http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_-1";
check(url,1005);

url="http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_";
check(url,1005);

url="http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_177";
check(url,0);


sys.stdout.close();
