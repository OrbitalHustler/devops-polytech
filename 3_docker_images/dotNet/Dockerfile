FROM mono:3.10.0

COPY ./2_cookie_factory_splitted/dotNet/ /opt/bank/
WORKDIR /opt/bank/
RUN ./compile.sh

ENTRYPOINT ["mono", "bank.exe"]
