# LegoStyleReconstruction
Our application is a Spring-Boot Web application which means it’s Java based. Basicly it could run any system. But since our model was written in Python, we do need to set up some python environment. And we also highly recommend using GPU instead of CPU to run the model. Our application environment details:
* Provider: Google Cloud Platform Virtual Machine
* OS: Ubuntu 14
* CPU: 4 vCPUs, 15 GB memory
* GPU: 1 x NVIDIA Tesla K80 (1 Single GPU, ½ Card)
* CUDA  8.0
* cuDNN 7.5
* Anaconda Python 3.3


* To use this application:
* Setup GPU instance according to above;
* Setup Python environment with Anaconda python 3;
* Install PyTorch dependency;
* Install Java 1.8;
* Put application jar file in the root node of your python code folder;
* “Mkdir -p ext-resources/script” “mkdir -p ext-resources/obj-dir”;
* Run application by “java -jar LegoStyleReconstruction-0.0.1-SNAPSHOT.jar”;
* Your are good to go.
