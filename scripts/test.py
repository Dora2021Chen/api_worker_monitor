#pip install requests   #using this command to install requests first in OS command window.

import requests,pprint
import sys
from datetime import datetime

sys.stdout=open("testResult.txt","w")


res = requests.get("http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_177");
resBody = res.json();
pprint.pprint(resBody);

if (resBody['statusCode'] == 0):
    print("pass");
else:
    print("fail");


res = requests.get("http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_");
resBody = res.json();
pprint.pprint(resBody);

if (resBody['statusCode'] == 1005):
    print("pass");
else:
    print("fail");


res = requests.get("http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=admin_-1");
resBody = res.json();
pprint.pprint(resBody);

if (resBody['statusCode'] == 1005):
    print("pass");
else:
    print("fail");


res = requests.get("http://localhost:8080/api/workerMonitor/worker/getWorkerStats?username=");
resBody = res.json();
pprint.pprint(resBody);

if (resBody['statusCode'] == 1003):
    print("pass");
else:
    print("fail");


sys.stdout.close();
