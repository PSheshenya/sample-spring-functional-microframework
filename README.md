# sample-spring-functional-microframework
Use Spring Framework as functional micro-framework without using SpringBootApplication Context 




####Check requests

```
sheshenya@mbp-sheshenya: ~/sample-spring-functional-microframework $ http :8080/json -v
GET /json HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:8080
User-Agent: HTTPie/1.0.2



HTTP/1.1 200 OK
Content-Length: 16
Content-Type: application/json

{
    "name": "world"
}
```

```
sheshenya@mbp-sheshenya: ~/sample-spring-functional-microframework $ http :8080  -v
GET / HTTP/1.1
Accept: */*
Accept-Encoding: gzip, deflate
Connection: keep-alive
Host: localhost:8080
User-Agent: HTTPie/1.0.2



HTTP/1.1 200 OK
Content-Length: 5
Content-Type: text/plain;charset=UTF-8

Hello
```


####HTTP benchmarking wia wrk tool https://github.com/wg/wrk

```
sheshenya@mbp-sheshenya: ~/sample-spring-functional-microframework $ wrk -t 10 -c 1000 -d 10s http://localhost:8080/
Running 10s test @ http://localhost:8080/
  10 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    60.94ms   71.58ms   1.95s    97.99%
    Req/Sec   309.67    333.40     1.48k    79.65%
  28556 requests in 10.09s, 2.26MB read
  Socket errors: connect 759, read 199, write 0, timeout 133
Requests/sec:   2829.58
Transfer/sec:    229.37KB


sheshenya@mbp-sheshenya: ~/sample-spring-functional-microframework $ wrk -t 10 -c 1000 -d 10s http://localhost:8080/json
Running 10s test @ http://localhost:8080/json
  10 threads and 1000 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    61.36ms   72.66ms   1.96s    98.85%
    Req/Sec   284.83    151.72   790.00     67.83%
  26844 requests in 10.04s, 2.23MB read
  Socket errors: connect 759, read 265, write 5, timeout 135
Requests/sec:   2674.41
Transfer/sec:    227.25KB
```