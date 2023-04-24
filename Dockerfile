FROM amd64/maven:3.5.4-jdk-8

ENV SCENARIO=
ENV TEST_ENV=


WORKDIR /code
COPY . .

RUN apt update
RUN apt install libglib2.0-0

RUN wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
RUN apt install -y ./google-chrome-stable_current_amd64.deb

RUN mvn compile

CMD ["sh", "-c", "/code/scripts/test.sh  ${TEST_ENV} ${SCENARIO}"]
# CMD ["bash"]
