# MQ 서버 셋팅
1. 가상머신에 CentOS 설치
2. Docker 설치
3. Docker 안에 RabbitMQ 설치


# 로직

"Producer --> MQ1 --> Consumer --> MQ2"

Producer가 MessageQueue1에 메세지를 produce하고  
Consumer가 RabbitMQ로부터 메세지를 consume해서 또다른 MessageQueue2에 produce


# 참고
- docker 설치  
  ㄴ참고: https://docs.docker.com/install/linux/docker-ce/centos/#uninstall-docker-ce


- rabbitmq 컨테이너 설치  
  ㄴ참고: http://abh0518.net/tok/?p=397  
$>docker run -d --hostname my-rabbit --name some-rabbit -p 8080:15672 -p 5672:5672 rabbitmq:3-management

- 실행중인 컨테이너에 접속  
  ㄴ참고: http://bluese05.tistory.com/21
$>docker exec -it [container_name 또는 container_id] /bin/bash

- rabbitmq 관리자 계정 추가  
  ㄴ참고: http://abh0518.net/tok/?p=384  
$>sudo rabbitmqctl add_user rabbitmq password  
$>sudo rabbitmqctl set_user_tags rabbitmq administrator


- rabbitmq 메세지 produce/consume 하기  
  ㄴ참고: http://abh0518.net/tok/?p=397  
  ㄴ참고: https://www.rabbitmq.com/tutorials/tutorial-one-java.html

- springboot+gradle 프로젝트의 jar 파일 생성 => (미완료)   
  ㄴ참고: http://gusrb.tistory.com/71  
$>gradle bootjar
  
- jar 파일을 docker 컨테이너로 올리기 => (미완료)   
  ㄴ참고: https://www.youtube.com/watch?v=E8cdA6ORbSM
