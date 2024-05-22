# This file is simply to allow the for multiplayer use
# The users IP is ciphered as to retain anonymity using https://github.com/woz07/bcipher

import socket
host = socket.gethostname()
ip_address = socket.gethostbyname(host)
print(f"Hostname: {host}")
print(f"IP Address: {ip_address})
