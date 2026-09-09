SKIP MESSAGING PROJECT - WINDOWS RUN GUIDE
==========================================

WHAT WAS FIXED
--------------
1. The receiver no longer compares its own ID with the sender ID.
2. VIEW RECEIVED MSG now automatically uses the correct sender ID.
3. The peer receiver listens on all local interfaces, including 127.0.0.1.
4. Send errors now show the real error message.
5. The sender flushes the message before closing the socket.
6. Address files are trimmed correctly.
7. Old internal Base64 classes were replaced with Java 8+ Base64.

REQUIREMENT
-----------
Install a Java JDK (JDK 8 or later). A JRE alone is not enough.

Open Command Prompt and check:

    java -version
    javac -version

Both commands must display a version.

EASY WAY TO RUN
---------------
1. Extract the ZIP to a simple location, for example:

       C:\SKIP_Messaging_Updated

2. Open the extracted SKIP_Messaging_Updated folder.

3. Double-click:

       RUN_PROJECT.bat

4. Allow access in Windows Firewall if Windows asks.

5. Wait for these server windows:

       KPA1, KPA2, KPA3, KPA4, KPA5, KPA6 and KGC

6. Two Peer Node windows will open.

7. In the first peer, enter port:

       1234

8. In the second peer, enter port:

       5678

REGISTER AND GET KEYS
---------------------
Do the following in BOTH peer windows:

1. Click REGISTER WITH KGC.
2. Enter a different name, for example:
       First peer:  acd
       Second peer: xyz
3. Write down the ID shown for each peer.
4. Click GET KEY FROM KPA'S.
5. Enter that peer's own ID.
6. Select any three different KPA options.
7. Click OK.

SEND A MESSAGE ON THE SAME COMPUTER
-----------------------------------
In the first peer (sender):

1. Select Destination:

       127.0.0.1

2. Port No:

       5678

3. Type a message.
4. Click Send.

RECEIVE AND DECRYPT
-------------------
In the second peer (receiver):

1. A notification should say that a message was received.
2. Click VIEW RECEIVED MSG.
3. Select any three different KPA options.
4. Click OK.
5. The decrypted message will be displayed.

SEND A REPLY
------------
In the second peer use:

    Destination: 127.0.0.1
    Port No:     1234

Then receive it in the first peer using VIEW RECEIVED MSG.

IMPORTANT
---------
- Each peer must use a different port.
- Start all six KPA servers before registering peers.
- Start KGC before clicking REGISTER WITH KGC.
- Keep all KPA and KGC windows open.
- For the same computer, use 127.0.0.1.

IF PORT 5678 IS BUSY
--------------------
Run:

    netstat -ano | findstr ":5678"

Close the old peer using that port, or select another unused receiver port
and enter that same port in the sender window.
