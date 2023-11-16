ls
adduser islab
docker exec -u islab -it Ubuntu4CT1107 /bin/bash
exit
apt-get update
apt-get install sudo -y
usermod aG sudo islab
usermod -aG sudo islab
exit
sudo passwd root
su -
exit
