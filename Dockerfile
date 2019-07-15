FROM alpine:3.8


WORKDIR /tmp

ENV ENV=dev



# Install packages

RUN apk upgrade -q -U -a
RUN apk add --update nginx 


# Create directories

RUN mkdir -p /app/www/
RUN mkdir -p /app/log/



# Copy the source into the container

WORKDIR /app/www
COPY . /app/www/

# Clean

RUN rm -rf /tmp/*
RUN rm -rf /var/cache/apk/*

EXPOSE 80

CMD cat
