# P2P-Model
This a realization of P2P resource distribution based on Multicast.

## Finding nodes
The whole process is based on a same multicast group. In this case, the address is 226.0.0.6:6666. First a node needs to send a join message. Once any node has received the message, they should ping the initial-join node and send all the hash-resources tables they know. All the nodes will exchange and update their resources table by doing adding-deleting process.

## Quitting mechanism
There are two quit mechanism.First is an active method, when a node want to exit, a quit message will be sent by itself to the multicast group then all the node will delete this peer and its resources. Another way is a passive one, when a node can't be pinged, a quit message will also be sent by other nodes.  

## What's more
I have also written down the tcp download script based on the exist IP and filename hash in the P2P table. The file is DownloadTCP.java and ThreadTcpDownload.java. This script can also develop some of the other app. Multicast is a really powerful protocol and I think P2P can take advantage on it. If you have any question you can contact me: hongyiz@kth.se

## Demo Results

### 192.168.3.108

A node join:192.168.3.108+

Your local file: [2-kleinberg.pdf， Assignment2.pdf]

Generated Local Resourses DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65]

RTT: 0.280 ms

Current node & RTT Latency[192.168.3.108:0.280]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65, 192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

quit

![192.168.3.108 Figure](https://github.com/Mr-Hongyi/P2P-Model/blob/master/Figure/192.168.3.108.png)

### 192.168.3.110

A node join：192.168.3.110+

Your local file: [Cover_Letter.docx, Resume of Hongyi Zhang.docx]

Generated Local Resourses DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

RTT: 0.163 ms

Current node & RTT Latency[192.168.3.110:0.163]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

A node join：192.168.3.108+

RTT: 94.845 ms

Current node & RTT Latency[192.168.3.110:0.163, 192.168.3.108:94.845]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde, 192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde, 192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde, 192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65]

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde, 192.168.3.108:4df551062c7c4eb0eeb2e7b73cc75b0b5649df3b, 192.168.3.108:7f8dd94b0a57c170dba55f28b88388ac3dc69a65]

A node quit：192.168.3.108-

Current DHT: [192.168.3.110:cc8b1dee8c047879eb1b4cf3a141fadc6166f481, 192.168.3.110:83c34207777c6f22a0438fefb85f8260e33d4bde]

Current node & RTT Latency[192.168.3.110:0.163]

quit

A node quit：192.168.3.110-

Current DHT: []

![192.168.3.108 Figure](https://github.com/Mr-Hongyi/P2P-Model/blob/master/Figure/192.168.3.110.png)
