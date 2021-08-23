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
        
def getUrl(username):
    apiUrl = "http://localhost:8080/api/workerMonitor/worker/getWorkerStats";
    url = apiUrl+"?username="+username;
    return url;

url=getUrl("admin_1111111111111111111111111111111111111111111111111111111111111111111");
check(url,1004);

url=getUrl("");
check(url,1003);

url=getUrl("admin_-1");
check(url,1005);

url=getUrl("admin_");
check(url,1005);

url=getUrl("admin_177");
check(url,0);


sys.stdout.close();
