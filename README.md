# SKIP Messaging Project

A Windows-based Java messaging project with a Key Generation Center
(KGC), six KPA servers, peer nodes, and a Shamir module.

## 📌 Project Overview

This project demonstrates a secure messaging setup using:

-   **KGC** (Key Generation Center)
-   **6 KPA servers**
-   **Peer Nodes**
-   **Shamir module**
-   **Java-based messaging**

The project is designed to run locally on a **Windows computer**.

------------------------------------------------------------------------

## 💻 Requirements

Before running the project, you need:

-   Windows
-   **Java JDK 8 or later**

> **Important:** A JDK is required. Installing only the JRE is not
> enough.

### Check your Java installation

Open **Command Prompt** and run:

``` cmd
java -version
javac -version
```

Both commands should display a Java version.

If `javac` is not recognized, install/configure the Java JDK before
continuing.

------------------------------------------------------------------------

## 🚀 Quick Start --- Easiest Method

If you are not familiar with Java, don't worry. The project includes a
batch file that starts the required components.

### 1. Download the project

Open the repository:

**https://github.com/hv086189-dot/Secret-Key-Extension**

On GitHub, click:

**Code → Download ZIP**

Extract the ZIP file to a simple location, for example:

``` text
C:\SKIP_Messaging_Updated
```

### 2. Start the project

Open the extracted project folder.

Double-click:

``` text
RUN_PROJECT.bat
```

If Windows Firewall asks for permission, allow the application as
appropriate for your local test environment.

### 3. Wait for the servers

The project should open the following server windows:

``` text
KPA1
KPA2
KPA3
KPA4
KPA5
KPA6
KGC
```

Two **Peer Node** windows should also open.

> Keep the KPA and KGC windows open while using the application.

------------------------------------------------------------------------

## 🔌 Peer Node Ports

The two peer nodes must use different ports.

The default setup is:

  Peer              Port
  ------------- --------
  First Peer      `1234`
  Second Peer     `5678`

For communication between two peers on the **same computer**, use:

``` text
127.0.0.1
```

------------------------------------------------------------------------

# 🔐 Register the Peer Nodes

Perform the following steps in **both Peer Node windows**.

### Step 1 --- Register with KGC

Click:

``` text
REGISTER WITH KGC
```

Enter a different name for each peer.

Example:

``` text
First Peer  → acd
Second Peer → xyz
```

Write down the ID shown for each peer.

### Step 2 --- Get keys from KPA servers

Click:

``` text
GET KEY FROM KPA'S
```

Enter that peer's **own ID**.

Select any **three different KPA options**.

Click **OK**.

Repeat these steps for the second peer.

> Make sure the KPA servers are running before registering peers and
> requesting keys.

------------------------------------------------------------------------

# 💬 Send a Message

The following example sends a message from the **first peer** to the
**second peer**.

In the first Peer Node:

### Destination

Enter:

``` text
127.0.0.1
```

### Port

Enter:

``` text
5678
```

Type your message and click:

``` text
Send
```

------------------------------------------------------------------------

# 📩 Receive and Decrypt a Message

On the second Peer Node:

1.  A notification should indicate that a message was received.
2.  Click:

``` text
VIEW RECEIVED MSG
```

3.  Select any **three different KPA options**.
4.  Click **OK**.
5.  The decrypted message should be displayed.

------------------------------------------------------------------------

# 🔁 Reply to a Message

The second peer can reply to the first peer.

In the second Peer Node, use:

### Destination

``` text
127.0.0.1
```

### Port

``` text
1234
```

Then send the reply.

On the first Peer Node, use:

``` text
VIEW RECEIVED MSG
```

and select any three different KPA options to receive and decrypt the
message.

------------------------------------------------------------------------

# ⚠️ Important Notes

-   Each peer must use a **different port**.
-   Start all **six KPA servers** before registering peers.
-   Start **KGC** before clicking `REGISTER WITH KGC`.
-   Keep all **KPA and KGC windows open** while using the application.
-   For two peers running on the same computer, use `127.0.0.1`.
-   When changing a peer's port, make sure the sender uses the same
    destination port.

------------------------------------------------------------------------

# 🛠️ Troubleshooting

## Port 5678 is already in use

If the second peer cannot use port `5678`, open Command Prompt and run:

``` cmd
netstat -ano | findstr ":5678"
```

If another process or an old Peer Node is using the port:

1.  Close the old Peer Node if it is no longer needed, **or**
2.  Choose another unused port.

For example:

``` text
Receiver Peer → 6000
Sender Destination Port → 6000
```

The sender's destination port must match the receiver's listening port.

------------------------------------------------------------------------

## 🧩 If the project does not start

Check the following:

1.  Java JDK is installed.
2.  Both commands work:

``` cmd
java -version
javac -version
```

3.  You extracted the complete ZIP file.
4.  You started the project using:

``` text
RUN_PROJECT.bat
```

5.  The KPA and KGC windows are running.
6.  The peer nodes are using different ports.

------------------------------------------------------------------------

# 📁 Project Structure

``` text
SKIP_Messaging_Updated/
│
├── KGC/
├── KPA/
├── peer node/
├── shamir/
│
├── compile_all.bat
├── README.md
├── README_RUN.txt
├── RUN_PROJECT.bat
├── start_peer.bat
└── start_servers.bat
```

### Main files

  File / Folder         Purpose
  --------------------- -----------------------------------------
  `KGC/`                KGC-related project files
  `KPA/`                KPA server project files
  `peer node/`          Peer Node application files
  `shamir/`             Shamir module
  `compile_all.bat`     Batch file for compiling the project
  `RUN_PROJECT.bat`     Main batch file for running the project
  `start_peer.bat`      Starts peer-related components
  `start_servers.bat`   Starts server-related components
  `README_RUN.txt`      Original Windows run guide
  `README.md`           This documentation

------------------------------------------------------------------------

# 👨‍💻 Beginner-Friendly Run Checklist

If you are new to the project, follow this checklist:

``` text
☐ Install Java JDK 8 or later
☐ Check java -version
☐ Check javac -version
☐ Download the GitHub ZIP
☐ Extract the ZIP
☐ Open the project folder
☐ Double-click RUN_PROJECT.bat
☐ Wait for KPA1–KPA6 and KGC
☐ Wait for the two Peer Node windows
☐ Register both peers with KGC
☐ Get keys from the KPA servers
☐ Use different ports for the two peers
☐ Send a message
☐ Receive and decrypt the message
```

------------------------------------------------------------------------

# 📖 Original Run Guide

The repository also contains:

``` text
README_RUN.txt
```

It provides the original Windows run instructions and troubleshooting
information.

------------------------------------------------------------------------

# 📌 Repository

GitHub repository:

**https://github.com/hv086189-dot/Secret-Key-Extension**

------------------------------------------------------------------------

## 📝 Project Notes

This project is intended to be run locally on Windows using the provided
batch files.

For the simplest experience, install the required JDK, download the
repository as a ZIP, extract it, and run:

``` text
RUN_PROJECT.bat
```

Keep the required server windows open while testing communication
between the peer nodes.
