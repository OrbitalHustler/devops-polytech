FROM mono:3.10.0

RUN mkdir -p /opt/bank
WORKDIR /opt/bank
COPY bank.exe .

ENTRYPOINT ["mono", "bank.exe"]
