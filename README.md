# CSE535-Project1

## Q1 : Imagine you are new to the programming world and not proficient enough in coding. But, you have a brilliant idea where you want to develop a context-sensing application like Project 1.  You come across the Heath-Dev paper and want it to build your application. Specify what Specifications you should provide to the Health-Dev framework to develop the code ideally. (15 points)

To develop a context-sensing application for monitoring heart rate, respiratory rate, and medical symptoms using the Health-Dev framework, we can provide the following specifications:

### 1. Sensor Specifications
- Define sensors for heart rate and respiratory rate
- Set appropriate sampling frequencies
- Specify sensor platform
- Define data processing algorithms (e.g., peak detection for heart rate)

### 2. Network Specifications
- Specify network topology and routing information
- Set radio duty cycling parameters for energy efficiency
- Define communication protocol (Bluetooth or ZigBee)

### 3. Smart Phone Specifications
- UI Components:
  - Graphs for heart rate and respiratory rate data
  - Text views for calculated metrics
  - Start/stop buttons
  - Input fields for symptom scores (1-5 scale)
- Specify phone-side algorithms (e.g., calculating averages)
- Define Bluetooth communication with sensors

### 4. Data Processing
- Specify algorithm execution sequence on sensors and phone
- Define thresholds for abnormal readings

### 5. Energy Management
- Set radio duty cycling parameters
- Specify adaptive transmission power control based on mobility

Provide these specifications in AADL format to Health-Dev. The framework will automatically generate code for sensors and the smartphone app, enabling rapid prototyping and implementation of your health monitoring system without extensive coding experience.


## Q2 : In Project 1 you have stored the user’s symptoms data in the local server. Using the bHealthy application suite how can you provide feedback to the user and develop a novel application to improve context sensing and use that to generate the model of the user? (15 points)


We can integrate following concepts from the **bHealthy** application suite to provide feedback to the user. The feedback can be in forms of recomedation, analysis, assesments etc. This will help develop a novel system for personalized health monitoring and wellness improvement.

### 1. Leveraging Physiological Feedback
Using the **bHealthy** suite as a foundation, the app will continuously track heart rate and respiratory rate via sensors, similar to how bHealthy utilizes ECG and EEG sensors to gather physiological signals. These signals will be processed and used to assess the user's physical condition. By employing algorithms akin to **bHealthy’s Emotiv Affectiv suite**, it will extract key parameters such as:
- **Heart Rate Variability (HRV)**: To assess stress and relaxation levels.
- **Respiratory Rate Analysis**: To detect irregularities related to physical health, such as shallow breathing or high respiratory rates.

This continuous monitoring will allow the app to provide real-time feedback to users, identifying patterns such as elevated heart rates or irregular breathing that could indicate potential health concerns.

### 2. Symptom-Based Health Assessment
The user’s self-reported symptoms, on a scale of 1-5, will be integrated into the app’s assessment system. Similar to **bHealthy’s assessment applications**, which detect mental states like frustration, relaxation, and excitement using EEG signals, the app will evaluate the user’s health by combining physiological signals with subjective symptom data. This comprehensive assessment will enable the app to:
- Identify correlations between physical symptoms and heart/respiratory data.
- Provide personalized feedback on potential health risks or issues.
  
For example, if a user reports fatigue and their heart rate is consistently high, the app might flag this combination as a potential issue and suggest resting or taking a break.

### 3. Activity Suggestions to Improve Health
One of the core features of **bHealthy** is its activity suggestion module, which recommends apps to help improve user well-being based on physiological assessments. My app will follow a similar approach:
- **Personalized Activity Recommendations**: After evaluating the user’s physical state and symptoms, the app will recommend activities tailored to their current needs. For instance:
  - If high stress levels are detected, the app might suggest mindfulness exercises or breathing techniques to help the user relax.
  - If the user exhibits low physical activity or reports feelings of lethargy, the app could recommend moderate physical activities such as walking or stretching.
  
By making these suggestions, the app will not only provide feedback but also encourage users to engage in activities that actively improve their health.

### 4. Building a Personalized User Model
To enhance context sensing and user-specific feedback, the app will create a personalized health model for each user. This model will:
- Track trends over time: By continuously recording heart rate, respiratory rate, and user-reported symptoms, the app will develop a profile that reflects the user’s overall health trends.
- Adapt to changes: Just as **bHealthy** provides wellness reports over time, my app will generate health reports that summarize trends in the user’s physiological data and symptoms. This model will allow the app to adapt its feedback and activity suggestions as the user’s health evolves.
  
For example, if the user’s heart rate is consistently elevated over a week, the app might shift from suggesting light exercise to recommending relaxation techniques or consulting a healthcare provider.

### 5. Novelty in Context Sensing and Feedback
The novel aspect of the app is its ability to combine **bHealthy's** physiological monitoring framework with user input to develop a comprehensive, adaptive feedback loop. The context sensing capabilities will continuously learn from the user’s data and improve over time. This will provide:
- **Real-time Feedback**: The app will immediately notify users if their physiological data shows concerning trends (e.g., elevated heart rate during resting periods).
- **Health Alerts**: If the app detects patterns that indicate potential health risks, it will send alerts encouraging the user to take preventive action (e.g., consulting a doctor if their symptoms persist).
- **Progress Tracking**: By generating periodic wellness reports, users will be able to see how their health is improving or declining over time, providing motivation for consistent engagement with health-improving activities.


## Q3 : A common assumption is mobile computing is mostly about app development. After completing Project 1 and reading both papers, have your views changed? If yes, what do you think mobile computing is about and why? If no, please explain why you still think mobile computing is mostly about app development, providing examples to support your viewpoint  (10 points)

Yes, my views have changed after understanding your project and reading the papers. Mobile computing is not just about app development; it's about creating integrated systems that involve real-time data processing, hardware interaction, and context-aware functionalities. It's about leveraging mobile devices as hubs that communicate with sensors, process complex data, and provide personalized feedback to users.

In our project, for example, the mobile app isn't just a standalone tool. It's part of a broader system that gathers physiological data, stores it, and as a future goal analyses and adapts in real-time to improve user health. This shows that mobile computing is about building intelligent, responsive ecosystems that go beyond simple app interfaces. It it also about understanding what design language might be connected to what set of users and emotions, felt like a brief intorfuciton to interaction design.