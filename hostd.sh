#!/bin/sh
HOME_DIR=/usr/local/hostd/
case "$1" in
	start)
    echo "Starting hostd..."
    java -jar ${HOME_DIR}war4e.jar &
    ;;
  stop)
    echo "Stopping hostd"
    kill `ps -ef | grep war4e.jar | grep java | cut -d " " -f 5`
    ;;
  restart)
    echo "Stopping hostd..."
    kill `ps -ef | grep war4e.jar | grep java | cut -d " " -f 5`
    sleep 2;
    echo "Starting hostd..."
    java -jar $HOME_DIR/hostd.jar -d"$HOME_DIR">> $HOME_DIR/log &
    ;;
  reload)
    echo "Reloading hostd"
    java -jar $HOME_DIR/lib/wifesays-1.0.0-alpha.jar -creload > /dev/null
    ;;
  zones)
    vi $HOME_DIR/config/zones
    java -jar $HOME_DIR/lib/wifesays-1.0.0-alpha.jar -creload > /dev/null
    ;;
  config)
    vi $HOME_DIR/config/hostd.conf
    java -jar $HOME_DIR/lib/wifesays-1.0.0-alpha.jar -creload > /dev/null
    ;;
  *)
    echo "Usage: $0 {start|stop|reload|zones|config|restart}"
    ;;
esac

exit 0