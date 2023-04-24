cucumber-jvm-template
=====================

This is a template project that you can use to start with cucumber-jvm and selenium java tests. Read about it on [seleniumframework.com](http://www.seleniumframework.com/cucumber-jvm-3/cucumber-jvm-and-selenium/)

# Full Tutorials

[Basic Tutorial](http://www.seleniumframework.com/cucumber-jvm-3/cucumber-jvm-and-selenium/)  
[Intermediate Tutorial](http://www.seleniumframework.com/cucumber-jvm-3/parameterize-browser/)  
[Advanced Tutorial/Frameworks](http://www.seleniumframework.com/cucumber-jvm-3/what-are-frameworks/)


# Nginx Config
```sh
server {
    listen       443 ssl http2 default_server;
    ...
    location / {
        autoindex on;
        root /home/centos/project/sg-altonomy-qa/www;
    }
    location /ExecutionReports/ {
        autoindex on;
        root /home/centos/project/sg-altonomy-qa;
    }
    location /target/ {
        autoindex on;
        root /home/centos/project/sg-altonomy-qa;
    }
    location /extent {
        # rewrite ^/(.*)$ /ExecutionReports/ redirect;
        return 301 /ExecutionReports/;
    }
    location /cucumber {
        # rewrite ^/(.*)$ /target/ redirect;
        return 301 /target/;
    }
    ...
}
```

# Docker Commands
```sh
# pull latest image
docker pull ecr.altono.app/altonomy/qa-bdd

# Run all tests
docker run -it --name <TEST_NAME> ecr.altono.app/altonomy/qa-bdd

# Run with specific test scenario
docker run -it --name <TEST_NAME> -e SCENARIO=<SCENARIO_NAME> ecr.altono.app/altonomy/qa-bdd

# Run with test scenario and export report
docker run -it --name <TEST_NAME> -e SCENARIO=<SCENARIO_NAME> -v <LOCAL_PATH>:/code/ExecutionReports ecr.altono.app/altonomy/qa-bdd

# Example: run all tests
docker run -it --name test_all -e SCENARIO= -v ~/0_all_scenarios/ExecutionReports:/code/ExecutionReports -v ~/0_all_scenarios/target:/code/target ecr.altono.app/altonomy/qa-bdd

# gracefully detach: ctrl + p + q
```
