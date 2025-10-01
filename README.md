# Name: jing chi ling  and ASU ID: 1233379825


## Q1 : Imagine you are new to the programming world and not proficient enough in coding. But, you have a brilliant idea where you want to develop a context-sensing application like Project 1.  You come across the Heath-Dev paper and want it to build your application. Specify what Specifications you should provide to the Health-Dev framework to develop the code ideally. (15 points)

To develop a context-sensing application for monitoring heart rate, respiratory rate, and medical symptoms using the Health-Dev framework, we can provide the following specifications:

### 1. Sensor Specifications
- Which sensors should I use (heart rate, respiration)?
- What sampling frequency per second is required?
- which platform will the sensors run
- Define data processing algorithms 

### 2. Network Specifications
- Connection methods between sensors or with mobile phones
- Protocol selection must consider transmission bandwidth, latency, and power consumption.
- communication protocol 

### 3. Smart Phone Specifications
- UI look like?:
  - camera for dectecting the HeartRate 
  - Graphs for heart rate and respiratory rate data
  - Start/stop buttons
  - Input fields for symptom scores (1-5 scale)
  - scrollrow for main and history ui
- Specify phone-side algorithms (e.g., calculating averages)

### 4. Data Processing
- Specify algorithm execution sequence on sensors and phone
- Perform feature extraction for heart rate and respiratory rate


## Q2 : In Project 1 you have stored the user’s symptoms data in the local server. Using the bHealthy application suite how can you provide feedback to the user and develop a novel application to improve context sensing and use that to generate the model of the user? (15 points)


We can integrate following concepts from the **bHealthy** application suite to provide feedback to the user. The feedback can be in forms of recomedation, analysis, assesments etc. This will help develop a novel system for personalized health monitoring and wellness improvement.

## 1. Leveraging Physiological Feedback
- Using the bHealthy suite as a foundation, the app will continuously track heart rate and respiratory rate via sensors, similar to how bHealthy utilizes ECG and EEG sensors to gather physiological signals. These signals will be processed and used to assess the user's physical condition. By employing algorithms akin to bHealthy’s Emotiv Affectiv suite, it will extract key parameters such as:
bHealthy uses sensors (like ECG and EEG) to collect signals. In my case, it's heart rate and respiration.

- It can perform analyses such as heart rate variability (HRV) to assess stress levels, or respiratory rate analysis to detect breathing abnormalities.

- This enables the system to provide real-time alerts to users, for instance, when stress levels are too high or breathing becomes too rapid.

## 2. Symptom-Based Health Assessment
- The symptom scores (1–5) entered by the user are integrated with physiological data.
  
- For example: If a user reports feeling “very tired” and has an abnormally high heart rate, the system can determine a potential health risk and recommend rest.

## 3. Building a User Model
- The system accumulates user data to gradually build a personalized health model.

## 4. Novelty in Context Sensing and Feedback
- Similar to bHealthy, but my approach uniquely combines “self-reporting” with “biometric sensing.”

- The advantage is more precise feedback, enabling real-time notifications and alerts, and even allowing users to visualize trends in their health progress.
## Q3 : A common assumption is mobile computing is mostly about app development. After completing Project 1 and reading both papers, have your views changed? If yes, what do you think mobile computing is about and why? If no, please explain why you still think mobile computing is mostly about app development, providing examples to support your viewpoint  (10 points)
- To be honest, at first I also thought mobile computing was mostly about developing apps. But after completing Project 1 and reading two papers, my perspective completely changed.
  Mobile computing isn't just about “writing an app”; it's about building an entire interactive system. This involves sensor data collection, real-time data processing, hardware interaction, and finally, through the core node of the smartphone, integrating, analyzing, and providing personalized feedback.
  Take our project as an example: this mobile app isn't an isolated program. It collects data from physiological signals like heart rate and breathing, stores this information, and then performs real-time analysis and feedback to help users improve their health. This goes beyond simple UI or feature development—it's about building an intelligent ecosystem that responds to the user's state.
  Therefore, for me, the essence of mobile computing has long transcended “building apps.” It's about creating a comprehensive solution that integrates sensing, computing, and feedback, transforming the smartphone into the central hub of smart living.

-Generative AI Acknowledgment: Portions of the code in this project were generated with assistance from ChatGPT, an AI tool developed by OpenAI.
Reference: OpenAI. (2024). ChatGPT [Large language model]. openai.com/chatgpt
* Estimated percentage of code influenced by Generative AI: 30%