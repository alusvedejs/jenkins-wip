FROM alpine:3.8


WORKDIR /tmp

ENV ENV=dev



# Install packages

RUN apk upgrade -q -U -a
RUN apk add --update nginx php7 php7-fpm php7-curl php7-pgsql php7-pdo php7-pdo_pgsql php7-mbstring php7-bcmath php7-mcrypt php7-phar php7-openssl php7-fileinfo php7-xmlwriter php7-xml php7-simplexml php7-zip php7-intl php7-soap php7-json php7-memcached php7-tokenizer php7-ctype php7-iconv php7-dom runit


# Create directories

RUN mkdir -p /app/www/
RUN mkdir -p /app/log/



# Copy the source into the container

WORKDIR /app/www
COPY . /app/www/

# Clean

RUN rm -rf /tmp/*
RUN rm -rf /var/cache/apk/*


