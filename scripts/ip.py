# gets ip of internet service provider

import socket

ip = ""
s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
try:
    s.connect(('8.8.8.8', 80)) # dummy address
    ip = s.getsockname()[0]
except Exception:
    ip = '127.0.0.1'

# write data to file so java can read

