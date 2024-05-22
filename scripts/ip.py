import socket
import os

# gets ip of internet service provider

ip = ''
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
try:
    s.connect(('8.8.8.8', 80)) # dummy address
    ip = s.getsockname()[0]
except Exception:
    ip = '127.0.0.1'

# write data to file so java can read
#
path = '/data/temp.txt'
# if os.path.exists(path):
#     print(f"Path exists: {path}")

try:
    with open(path, 'w') as file:
        file.write(ip)
    print(f"Data successfully written to {path}")
except Exception as e:
    print(f"An error occurred while writing to file : {e}")