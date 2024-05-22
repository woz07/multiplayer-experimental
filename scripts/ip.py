import socket
import os

# gets IP of internet service provider
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
try:
    s.connect(('8.8.8.8', 80))  # dummy address
    ip = s.getsockname()[0]
except Exception:
    ip = '127.0.0.1'
finally:
    s.close()

# write data to temp txt file in data folder so Java can read
path = 'data/temp.txt'

# make sure directory exists
os.makedirs(os.path.dirname(path), exist_ok=True)

with open(path, 'w') as file:
    file.write(ip)
