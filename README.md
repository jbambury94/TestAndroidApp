<H1> Andriod app (Native Framework) for Pendo Mobile Testing. </H1>

<H2> Prerequites </H2>

Android Studio has been installed via Pendo Self-Service.

<H2> Steps: </H2>

Open Andriod Studio

<strong> If git is installed </strong> Click 'Get From VCS' on welcome screen

<img width="811" alt="Screenshot 2025-01-09 at 10 16 18" src="https://github.com/user-attachments/assets/95aa2476-e2ea-47c6-b5b1-c601d987303c" />


Enter https://github.com/jbambury94/TestAndroidApp.git in URL


Click Clone.

If you don't have git please download the code as a zip, decompress and open in Android Studion directly. 


Click 'Trust Project' if popup appears.


After opening the project, select View > Tool Windows > Device Manager from the main menu bar, then click the +, and then click Create Virtual Device.

<img width="721" alt="Screenshot 2025-01-09 at 10 51 59" src="https://github.com/user-attachments/assets/d3704b7f-20d9-4098-946d-4bd58c368c4d" />


Select Pixel 9 and click next.


Select 'VanillaIceCream' and click next


Wait for the Device to download and install. Click finish, next and finish when done.

<h3>Code Changes</h3>

<img width="1007" alt="Screenshot 2025-01-09 at 10 53 35" src="https://github.com/user-attachments/assets/edafee24-16c5-4467-af05-cd4965e6a40e" />


<H4> Update Scheme ID </H4>
Open app/manifest/AndroidManifest.xml </br>

<img width="501" alt="Screenshot 2025-01-09 at 10 48 38" src="https://github.com/user-attachments/assets/6f68b14f-da64-4b31-a951-7c7bd99eb221" />


Search for <Strong> ENTER SCHEME_ID HERE </strong> and enter the Scheme ID found in your mobile application in the Pendo UI.


<H4> Update Api key </H4>
Open app/java/com.example.testnative/MainActivity </br>

<img width="501" alt="Screenshot 2025-01-09 at 10 49 36" src="https://github.com/user-attachments/assets/1ad86947-0c10-402f-ad00-d569287671ae" />


Search for <strong> ENTER API_KEY HERE </strong> and enter the application API Key found in your mobile application in the Pendo UI.



<h5> Optional: </h5>
Update to include custom Visitor and Account Metadata in MainActivity.java

<H4>How to Run app</H4>

Click the Play 'Run 'app'.

<img width="674" alt="Screenshot 2025-01-09 at 10 29 15" src="https://github.com/user-attachments/assets/7f6e2900-6cbd-4916-aef2-26a14aecab1f" />


Virtual device will now load and be ready for verifying your install in the Pendo UI - https://support.pendo.io/hc/en-us/articles/24595803113883-Verify-your-mobile-app-installation. 
