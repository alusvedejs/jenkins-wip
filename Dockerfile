FROM alpine:3.8


WORKDIR /tmp

ENV ENV=dev



# Install packages

RUN apk upgrade -q -U -a


CMD cat
