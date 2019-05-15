package com.androidcodeshop.aiq;

import android.util.Log;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Questions {
    private static ArrayList<QuestionAnswerModel> questionsAns;

    private Questions() {
    }

    public static ArrayList<QuestionAnswerModel> getInstance() {
        questionsAns = new ArrayList<>();
        populateQuestions();
        return questionsAns;
    }

    public static int getNumberOfQuestion() {
        return getInstance().size();
    }

    private static void populateQuestions() {
        questionsAns.add(new QuestionAnswerModel(1, "What is Android ? ", "Android is a mobile operating system developed by Google. It is based on a modified version of the Linux kernel and other open source software, and is designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface. Variants of Android are also used on game consoles, digital cameras, PCs and other electronics.\n" +
                "\n" +
                "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007, with the first commercial Android device launched in September 2008. The operating system has since gone through multiple major releases, with the current version being 9 \"Pie\", released in August 2018. Google released the first Android Q beta on all Pixel phones on March 13, 2019. The core Android source code is known as Android Open Source Project (AOSP), and is primarily licensed under the Apache License."));
        questionsAns.add(new QuestionAnswerModel(2, "What is an Application?", "" +
                "An application is something " +
                "that a user might install from the Play Store or otherwise download to their device. " +
                "That application should have some user interface, and it might have other code " +
                "designed to work in the background (multi-tasking). for example- This application has some UI which provides the important questions and answers."));
        questionsAns.add(new QuestionAnswerModel(3, "Which are the programming languages in which we can write the mobile applications?", "" +
                "There are many languages in which we can write the mobile application but Java is the most extensively used and now Kotlin is recommended by google." +
                "Other languages are : \n" +
                "C/C++ for performance gain\n" +
                "C/C++ with OpenGL for 3D applications and Camera Applications\n" +
                "You can also use HTML, CSS and JavaScript for writing web modules in android"));
        questionsAns.add(new QuestionAnswerModel(4, "What are the different components in Android?", "" +
                "There are main four components in Android :\n" +
                "   1.Activities : Building blocks of User Interface(UI)\n" +
                "   2.Broadcast Receiver : Helps in receiving the broadcast such as Battery low, Network connections, reboot and so many..\n" +
                "   3.Services : Background threads in android, can run independent of activity\n" +
                "   4.Content Provides : Provides the abstraction on data stored in the devices that is accessible by multiple applications such as contacts, files etc."));
        questionsAns.add(new QuestionAnswerModel(5, "What is Widgets or Views ?", "" +
                "A control element (sometimes called a control or widget) in a graphical user interface is an element of interaction, such as a button or a scroll bar.(-wiki) \n\n" +
                "Widgets or Views are the micro units of User Interface Design in Android. " +
                "Example : \n" +
                "Buttons\n" +
                "Fields\n" +
                "Labels\n" +
                "RadioButton, CheckBoxes, etc\n" +
                "These are generally Java classes which extends the View class. such as TextView extends View"));
        questionsAns.add(new QuestionAnswerModel(6, "What is Dalvik and ART and what is difference between them?",
                "In terms of Android, Dalvik and ART are virtual machines (VM)s. Virtual machines\n" +
                        "are used by many programming languages, such as Java, Perl, and Smalltalk. Dalvik\n" +
                        "and ART are designed to work much like a Java VM, but optimized for embedded\n" +
                        "Linux environments.\n" +
                        "Primarily, the difference between the two is that ART is used on Android 5.0 and\n" +
                        "higher, while Dalvik was used on older devices."));
        questionsAns.add(new QuestionAnswerModel(7, "What is Emulator in Android Studio?",
                "An Emulator is a piece of software that pretends to be an " +
                        "Android device. This is very useful for development — not only does it mean you " +
                        "can get started on Android without a device, but the emulator can help test device " +
                        "configurations that you do not own.\n" +
                        "There are two types of emulator: x86 and ARM. These are the two major types of " +
                        "CPUs used for Android devices. You really want to be able to use the x86 emulator, " +
                        "as the ARM emulator is extremely slow.\n" +
                        "However, to use the x86 emulator, your development machine must have things set " +
                        "up properly first. Linux users need KVM, while Mac and Windows users need the " +
                        "“Intel Hardware Accelerated Execution Manager” (a.k.a., HAXM).\n" +
                        "Also, this only works for certain CPU architectures, ones that support virtualization\n" +
                        "in hardware:\n" +
                        "• Intel Virtualization Technology (VT, VT-x, vmx) extensions\n" +
                        "• AMD Virtualization (AMD-V, SVM) extensions (Linux only)"));

        //Gradle based questions
        questionsAns.add(new QuestionAnswerModel(8, "What is gradle?",
                "Gradle is software for building software, otherwise known as “build automation " +
                        "software” or “build systems”.A build system does not compile, link, package, etc. applications " +
                        "directly, but instead directs separate compilers, linkers, and packagers to do that " +
                        "work.\n" +
                        "Gradle uses a domain-specific language (DSL) built on top of Groovy to accomplish " +
                        "these tasks."));
        questionsAns.add(new QuestionAnswerModel(9, "What is Groovy?",
                "Groovy is an programmin language which runs on the top of Java like many other languages and it supports : \n" +
                        "   • Defining class with class keyword\n" +
                        "   • Creating subclasses using extends\n" +
                        "   • Importing classes from external JARs using import\n" +
                        "   • Defining method bodies using braces ({ and })\n" +
                        "   • Objects are created via the new operator\n" +
                        "Groovy is an interpreted language, like Ruby and unlike Java. Groovy scripts are run " +
                        "by executing a groovy command, passing it the script to run. The Groovy runtime, " +
                        "though, is a Java JAR and requires a JVM in order to operate.\n" +
                        "One of Groovy’s strengths is in creating a domain-specific language (or DSL). " +
                        "Gradle, for example, is a Groovy DSL for doing software builds. Gradle-specific " +
                        "capabilities appear to be first-class language constructs, generally indistinguishable " +
                        "from capabilities intrinsic to Groovy. Yet, the Groovy DSL is largely declarative, like " +
                        "an XML file."));
        questionsAns.add(new QuestionAnswerModel(10, "What Does Android Have To Do with Gradle?",
                "Google has published the Android Gradle Plugin, which gives Gradle the ability to\n" +
                        "build Android projects. Google is also using Gradle and the Android Gradle Plugin\n" +
                        "as the build system behind Android Studio."));
        questionsAns.add(new QuestionAnswerModel(11, "What is gradle wrapper ?",
                "The Gradle Wrapper consists of three pieces:\n" +
                        "• the batch file (gradlew.bat) or shell script (gradlew)\n" +
                        "• the JAR file used by the batch file and shell script (in the gradle/wrapper/" +
                        "directory)\n" +
                        "• the gradle-wrapper.properties file (also in the gradle/wrapper/ directory)\n" +
                        "Android Studio uses the gradle-wrapper.properties file to determine where to " +
                        "download Gradle from, for use in your project, from the distributionUrl property " +
                        "in that file:\n" +
                        "#Thu May 10 08:57:09 EDT 2018\n" +
                        "distributionBase=GRADLE_USER_HOME\n" +
                        "distributionPath=wrapper/dists\n" +
                        "zipStoreBase=GRADLE_USER_HOME\n" +
                        "zipStorePath=wrapper/dists\n" +
                        "distributionUrl=https\\://services.gradle.org/distributions/gradle-4.4-all.zip"));
        questionsAns.add(new QuestionAnswerModel(12, "What is project level build.gradle ?",
                "The build.gradle file in the project directory controls the Gradle configuration for " +
                        "all modules in your project.\n" +
                        "Example and Description : \n" +
                        "// Top-level build file where you can add configuration options common to all subprojects/" +
                        "modules.\n" +
                        "buildscript {\n" +
                        "   repositories {\n" +
                        "       google()\n" +
                        "       jcenter()\n" +
                        "       }\n" +
                        "   dependencies {\n" +
                        "       classpath 'com.android.tools.build:gradle:3.3.1'\n" +
                        "// NOTE: Do not place your application dependencies here; they belong\n" +
                        "// in the individual module build.gradle files\n" +
                        "       }\n" +
                        "}\n" +
                        "allprojects {\n" +
                        "   repositories {\n" +
                        "       google()\n" +
                        "       jcenter()\n" +
                        "   }\n" +
                        "}\n" +
                        "task clean(type: Delete) {\n" +
                        "   delete rootProject.buildDir\n" +
                        "}\n" +
                        "\n" +
                        "The repositories closure inside the buildscript closure indicates where plugins " +
                        "can come from. Here, jcenter() is a built-in method that teaches Gradle about " +
                        "JCenter, a popular location for obtaining open source libraries. Similarly, google() is " +
                        "a built-in method that teaches Gradle about a site where it can download plugins " +
                        "from Google.\n\n" +
                        "The dependencies closure indicates what is required to be able to run the rest of the " +
                        "build script.\n\n" +
                        "allprojects\n\n" +
                        "The allprojects closure says “apply these settings to all modules in this project”. " +
                        "Here, we are setting up jcenter() and google() as places to find libraries used in " +
                        "any of the modules in our project. We will use lots of libraries in our projects — " +
                        "having these “repositories” set up in allprojects makes it simpler for us to request " +
                        "them."));

        questionsAns.add(new QuestionAnswerModel(13, "What is module level build.gradle ?",
                "In your app/ module, you will also find a build.gradle file. This has settings unique " +
                        "for this module, independent of any other module that your project may have in the " +
                        "future.\n" +
                        "\n" +
                        "\nandroid\n" +
                        "The android closure contains all of the Android-specific configuration information. " +
                        "This closure is what the Android plugin enables, where the plugin itself comes from " +
                        "the apply plugin: 'com.android.application' line at the top, coupled with the " +
                        "classpath line from the project-level build.gradle file.\n\n" +
                        "dependencies\n" +
                        "This build.gradle file also has a dependencies closure. Whereas the dependencies " +
                        "closure in the buildscript closure in the top-level build.gradle file is for libraries " +
                        "used by the build process, the dependencies closure in the module’s build.gradle " +
                        "file is for libraries used by your code in that module."));

        questionsAns.add(new QuestionAnswerModel(14, "What is Android Manifest file in Android ?",
                "The AndroidManifest.xml is the foundation of android application and it contains all the information about the application " +
                        ", here we declare all the activities, receivers, content providers, services, permissions and so on. \n" +
                        "All the activities that are used in the application is defined inside this with their properties such as which is LAUNCHER activity and which is default. "));

        questionsAns.add(new QuestionAnswerModel(15, "Which tag is used in android manifest to show that we support multiple screens?",
                "<support-screens> tag is used to show that we support different size screens as follows :\n" +
                        "<supports-screens\n" +
                        "android:largeScreens=\"true\"\n" +
                        "android:normalScreens=\"true\"\n" +
                        "android:smallScreens=\"false\"\n" +
                        "android:xlargeScreens=\"true\" />"));
        questionsAns.add(new QuestionAnswerModel(16, "What does android:allowBackup=\"true\" represents?",
                "This attribute indicates that our application " +
                        "should participate in Android’s automatic backup system. By default it can backup upto 25MB data. It's not good idea to use it until you know the technicals consequences."));

        questionsAns.add(new QuestionAnswerModel(17, "What is Lint ?",
                "The Android lint tool is a static code analysis tool that checks your Android project source files for potential bugs and optimization improvements for correctness, security, performance, usability, accessibility, and internationalization."));
        questionsAns.add(new QuestionAnswerModel(18, "What is Resources in Android?",
                "Resources are static bits of information held outside the Java source code. As we " +
                        "discussed previously, resources are stored as files under the res/ directory in your " +
                        "source set (e.g., app/src/main/res/). Here is where you will find all your icons and " +
                        "other images, your externalized strings for internationalization, and more."));
        questionsAns.add(new QuestionAnswerModel(19, "What is Html in string ?", "" +
                "We can Display the Html in TextView using CDATA tag.\n" +
                "usage : \n" +
                "<string name=\"report_body\">\n" +
                "<![CDATA[\n" +
                "<html>\n" +
                "   <body>\n" +
                "       <h1>TPS Report for: {{reportDate}}</h1>\n" +
                "           <p>Here are the contents of the TPS report:</p>\n" +
                "           <p>{{message}}</p>\n" +
                "           <p>If you have any questions regarding this report, please do <b>not</b> ask Mark Murphy.</p>\n" +
                "   </body>\n" +
                "</html>\n" +
                "]]>\n" +
                "</string>"));
        questionsAns.add(new QuestionAnswerModel(20, "What Are Containers ?",
                "Containers are ways of organizing multiple widgets into some sort of structure. " +
                        "Widgets do not naturally line themselves up in some specific pattern — we have to " +
                        "define that pattern ourselves.\n" +
                        "In most GUI toolkits, a container is deemed to have a set of children. Those children " +
                        "are widgets, or sometimes other containers. Each container has its basic rule for how " +
                        "it lays out its children on the screen, possibly customized by requests from the " +
                        "children themselves.\n" +
                        "\n" +
                        "Containers are layout in general terms, for example \n" +
                        "   -LinearLayout\n" +
                        "   -RelativeLayout\n" +
                        "   -ConstraintLayout\n" +
                        "etc..." +
                        "\n" +
                        "Note : A Container can have their own padding , size, margin and can contain another container."));

        questionsAns.add(new QuestionAnswerModel(21, "What is aapt ?",
                "AAPT stands for Android Asset Packaging Tool. This tool is part of the SDK (and build system) and allows you to view, create, and update Zip-compatible archives (zip, jar, apk). It can also compile resources into binary assets.\n" +
                        "This tool will be " +
                        "automatically invoked by your Android tool chain (e.g., Android Studio). Of " +
                        "particular importance to you as a developer is that aapt generates an R.java source file, allowing you to access layouts and widgets within those layouts directly from " +
                        "your Java code. In other words, this is where that magic R value used in " +
                        "setContentView() comes from."));


        questionsAns.add(new QuestionAnswerModel(22, "What is the difference between @id/xyz and @+id/xyz ?",
                "The @ symbol in android is used to refer the reference. The id is used to uniquely identify " +
                        "the element inside the XML file and to get the reference of that element inside the java file." +
                        " @id means we are referring to an id which is already created and in @+id, the + denotes that we are " +
                        "creating the id  \n" +
                        "\n" +
                        "example : android:id=”@+id/bar_code_btn”  \n" +
                        "\n" +
                        "In the above line, we are creating the bar_code_btn id, that we can use in java file to reference the " +
                        "element with this id.\n" +
                        "\n" +
                        "example: android:layout_below=”@id/category_btn”\n" +
                        "\n" +
                        "In this above line, the category_btn is an Id which is already defined in some element/view and we are" +
                        " just referencing that element to align our view. here we are not creating any id."));

        questionsAns.add(new QuestionAnswerModel(23, "What is Logcat ?",
                "Logcat is a tool in Android Studio which helps you debug the application, Logcat will show your stack traces, diagnostic information from the operating " +
                        "system, and anything you wish to include via calls to static methods on the " +
                        "android.util.Log class. For example, Log.e() will log a message at error severity, " +
                        "causing it to be displayed in red.\n" +
                        "If you want to send something from Logcat to somebody else, such as via an issue " +
                        "tracker, just highlight the text and copy it to the clipboard, as you would with any " +
                        "text editor."));

        questionsAns.add(new QuestionAnswerModel(24, "How to Debug the Android Applications ?",
                "There are mainly two ways through which we debug : \n" +
                        "   1.Logcat - We Use Log class to print different kind of output in logcat window, such as Log.e() for error, Log.i for information , log.v  for verbose etc .\n" +
                        "   2.Break points(ADB) - This method provides the realtime application debugging using debugger(bug-shaped button to the right of the “run” green triangle will launch your app\n" +
                        "and attach the debugger, so breakpoints will be honored). \n\n" +
                        "If your app is already " +
                        "running, and you want to debug the running process, you can do that via the toolbar " +
                        "button that looks like a phone with a small bug in the lower-right corner."));
        questionsAns.add(new QuestionAnswerModel(25, "What is RTL and LTR ?",
                "RTL and LTR are the language directions. Most of the languages are LTR(Left-To-Right) such as english, hindi, french etc but there are other languages\n" +
                        "such as hebrew and arabic which are written RTL(Right-To-Left). \n\n" +
                        "Android provides support for both kind of language directions.\n\n" +
                        "Slowly, Android improved its RTL support. In particular, starting with API Level 17 " +
                        "(Android 4.2), analogue attributes were added, replacing “left” with “start” and " +
                        "“right” with “end”. When using “start”/“end” attributes (e.g., android:paddingStart), " +
                        "“start” refers to where you start reading a line of text, and “end” refers to where you " +
                        "end reading a line of text."));

        questionsAns.add(new QuestionAnswerModel(26, "What is LinearLayout ?",
                "LinearLayout represents Android’s approach to a box model — widgets or child " +
                        "containers are lined up in a column or row, one after the next.\n" +
                        "\n" +
                        "Orientation\n" +
                        "Orientation indicates whether the LinearLayout represents a row or a column. Just " +
                        "add the android:orientation property to your LinearLayout element in your XML " +
                        "layout, setting the value to be horizontal for a row or vertical for a column. " +
                        "The orientation can be modified at runtime by invoking setOrientation() on the " +
                        "LinearLayout, supplying it either HORIZONTAL or VERTICAL."));

        questionsAns.add(new QuestionAnswerModel(27, "What is adapter ?",
                "An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set.\n\n" +
                        "Example : ArrayAdapter, CursorAdapter, SimpleCursorAdapter etc..\n" +
                        "\nWe can create our own adapter according to our need such as Adapter for GridView, RecyclerView and ListView."));

        questionsAns.add(new QuestionAnswerModel(28, "What are launch modes in Android ?",
                " Launch mode allows you to define how a new instance or the existing instance of an activity is associated with the current task. The activity launch mode has four valid values:\n" +
                        "\n" +
                        "<activity android:launchMode = [\"standard\" | \"singleTop\" | \"singleTask\" | \"singleInstance\"] ../>\n\n" +
                        "Please check this post for more details\n" +
                        "https://medium.com/@iammert/android-launchmode-visualized-8843fc833dbe"));

        questionsAns.add(new QuestionAnswerModel(29, "What i REALM Database ?",
                "Realm is a lightweight database that can replace both SQLite and ORM libraries in your Android projects. Compared to SQLite, Realm is faster and has lots of modern features, such as JSON support, a fluent API, data change notifications, and encryption support, all of which make life easier for Android developers."));
        questionsAns.add(new QuestionAnswerModel(30, "What is an Activity ?",
                "An activity represents a single screen with a user interface just like window or frame of Java.Android activity is " +
                        "the subclass of ContextThemeWrapper class.\n" +
                        "An activity provides the window in which the app draws its UI. This window typically fills the screen, but may be smaller than the screen and float on top of other windows. Generally, one activity implements one screen in an app. For " +
                        "instance, one of an app’s activities may implement a Preferences screen, while another activity implements a Select Photo screen.\n" +
                        "\nManifest Declaration\n" +
                        "<activity android:name=\".ExampleActivity\" />"));
        questionsAns.add(new QuestionAnswerModel(31, "Explain Activity Lifecycle ?",
                "An Android activity is a stand-alone component of android application development that can be started, stopped, paused, restarted and so on\n" +
                        "   1.onCreate()\n" +
                        "   2.onStart()\n" +
                        "       onRestoreInstanceState()()\n" +
                        "   3.onResume()\n" +
                        "   4.Running state\n" +
                        "   5.onPause()\n" +
                        "       onSaveInstanceState()\n" +
                        "   6.onStop()\n" +
                        "       onRestart()\n" +
                        "   7.onDestroy()\n" +
                        "For complete explaination please visit \n" +
                        "https://androidcodeshop.com/2018/12/05/android-activity-life-cycle/"));
        questionsAns.add(new QuestionAnswerModel(32, "What is the role of ViewHolder in Adapter ?",
                "To get the view we inflate the row view and fetch the child with findViewById(), findViewById() is an expensive operation and it is done again and again whenever it recycle the list item. To avoid this" +
                        " situation we use ViewHolder pattern/ Every View has setTag() and getTag() method which helps to associate a random object to that view..\n" +
                        "What the holder pattern does is use that “tag” to " +
                        "hold an object that, in turn, holds each of the child widgets of interest. By attaching " +
                        "that holder to the row View, every time we use the row, we already have access to the " +
                        "child widgets we care about, without having to call findViewById() again. "));
        questionsAns.add(new QuestionAnswerModel(33, "What is fragment?",
                "A fragment is usually used as part of an activity's user interface and contributes its own layout to the activity. To provide a layout for a fragment, you must implement the onCreateView() callback method, which the Android system calls when it's time for the fragment to draw its layout."));
        questionsAns.add(new QuestionAnswerModel(34, "Explain the fragment lifecycle?",
                "Fragment lifecycle is bit complex and includes more method than activity lifecycle management. The lifecycle methods are as follow :\n" +
                        "   1.onAttach() - Called when the fragment has been associated with the activity\n" +
                        "   2.onCreate() - The system calls this when creating the fragment. initialization goes here in general.\n" +
                        "   3.onCreateView() - Called to create the view hierarchy associated with the fragment.\n" +
                        "   4.onActivityCreated() - Called when the activity's onCreate() method has returned.\n" +
                        "   5.onStart() - When fragment is visible \n" +
                        "   4.onResume()\n" +
                        "   7.onPause() - The system calls this method as the first indication that the user is leaving the fragment (though it doesn't always mean the fragment is being destroyed). This is usually where you should commit any changes that should be persisted beyond the current user session \n" +
                        "   8.onStop()\n" +
                        "   9.onDestroyView() - Called when the view hierarchy associated with the fragment is being removed.\n" +
                        "   10.onDestroy()\n" +
                        "   11.onDetach() - Called when the fragment is being disassociated from the activity.\n" +
                        "For complete explanation visit - \n" +
                        "https://developer.android.com/guide/components/fragments#Lifecycle"));

        questionsAns.add(new QuestionAnswerModel(35, "How fragments communicate with activity?",
                "To allow a Fragment to communicate up to its Activity, you can define an interface in the Fragment class and implement it within the Activity. The Fragment captures the interface implementation during its onAttach() lifecycle method and can then call the Interface methods in order to communicate with the Activity.\n" +
                        "\n" +
                        "For sample code and usage please follow this link : \n" +
                        "https://developer.android.com/training/basics/fragments/communicating#DefineInterface"));
        questionsAns.add(new QuestionAnswerModel(36, "How to communicated between two fragments ?",
                "All Fragment-to-Fragment communication is done either through a shared ViewModel or through the associated Activity. Two Fragments should never communicate directly.\n" +
                        "\n" +
                        "The recommended way to communicate between fragments is to create a shared ViewModel object. Both fragments can access the ViewModel through their containing Activity. The Fragments can update data within the ViewModel and if the data is exposed using LiveData the new state will be pushed to the other fragment as long as it is observing the LiveData from the ViewModel.\n" +
                        "To see the code demo please visit : \n" +
                        "https://developer.android.com/topic/libraries/architecture/viewmodel.html#sharing"));

        questionsAns.add(new QuestionAnswerModel(37, "What is handler ?",
                "A Handler allows you to send and process Message and Runnable objects associated with a thread's MessageQueue. Each Handler instance is associated with a single thread and that thread's message queue. When you create a new Handler, it is bound to the thread / message queue of the thread that is creating it -- from that point on, it will deliver messages and runnables to that message queue and execute them as they come out of the message queue.\n" +
                        "There are two main uses for a Handler: (1) to schedule messages and runnables to be executed at some point in the future; and (2) to enqueue an action to be performed on a different thread than your own. \n" +
                        "for more information please visit : \n" +
                        "https://medium.com/@ankit.sinhal/handler-in-android-d138c1f4980e"));
        questionsAns.add(new QuestionAnswerModel(38, "What is looper ?",
                "\n" +
                        "What is Looper?\n" +
                        "\n" +
                        "Looper is a class which is used to execute the Messages(Runnables) in a queue. Normal threads have no such queue, e.g. simple thread does not have any queue. It executes once and after method execution finishes, the thread will not run another Message(Runnable).\n" +
                        "\n" +
                        "Where we can use Looper class?\n" +
                        "\n" +
                        "If someone wants to execute multiple messages(Runnables) then he should use the Looper class which is responsible for creating a queue in the thread. For example, while writing an application that downloads files from the internet, we can use Looper class to put files to be downloaded in the queue.\n" +
                        "\n" +
                        "How it works?\n" +
                        "\n" +
                        "There is prepare() method to prepare the Looper. Then you can use loop() method to create a message loop in the current thread and now your Looper is ready to execute the requests in the queue until you quit the loop.\n" +
                        "for code demo please visit : \n" +
                        "https://stackoverflow.com/a/7597897/5163725"));
        questionsAns.add(new QuestionAnswerModel(39, "What is Message in Android ? ",
                "Object class defines the Message class which contains description and arbitary data object that can be sent " +
                        "to an Handler. This object contains two extra int fields and an extra object field that allow you to not do allocations in many cases. \n" +
                        "\nWhile the constructor of Message is public, the best way to get one of these is to call Message.obtain() or one of the Handler#obtainMessage methods, which will pull them from a pool of recycled objects.\n" +
                        "please follow the link for code demo :\n" +
                        "https://alvinalexander.com/source-code/android-how-send-message-from-thread-to-handler"));
        questionsAns.add(new QuestionAnswerModel(40, "What is the relationship between Looper, Handler and MessageQueue in Android?\n",

                "A Looper is a message handling loop: it reads and processes items from a MessageQueue. The Looper class is usually used in conjunction with a HandlerThread (a subclass of Thread).\n" +
                        "\n" +
                        "A Handler is a utility class that facilitates interacting with a Looper—mainly by posting messages and Runnable objects to the thread's MessageQueue. When a Handler is created, it is bound to a specific Looper (and associated thread and message queue).\n" +
                        "\n" +
                        "In typical usage, you create and start a HandlerThread, then create a Handler object (or objects) by which other threads can interact with the HandlerThread instance. The Handler must be created while running on the HandlerThread, although once " +
                        "created there is no restriction on what threads can use the Handler's scheduling methods (post(Runnable), etc.)"));
        questionsAns.add(new QuestionAnswerModel(41, "What is Notification Channel in Android Oreo ?",
                "Notification Channels provide us with the ability to group the notifications that our application sends into manageable groups. Once our notifications are in these channels, we no longer have input into their functionality — so it is up to the user to manage these channels.\n" +
                        "\n" +
                        " From here the user can:\n" +
                        "\n" +
                        "Block all notification channels for our app. This means that notifications from our application will never be shown on the users device\n" +
                        "If supported, the user can state whether or not our applications notifications should be shown as badges on the Home app\n" +
                        "The notification categories that exist for our application. From here the user can toggle these to be enabled or disabled\n" +
                        "for more details please visit : \n" +
                        "https://medium.com/exploring-android/exploring-android-o-notification-channels-94cd274f604c"));
        questionsAns.add(new QuestionAnswerModel(42, "What is UI Thread and ANR ?",
                "The main thread which is responsible for execution of every message and for creating the UI is called UI Thread in Android and if there is some process or operations which takes long time and blocks " +
                        "the UI Thread results into \"Application Not Responding(ANR)\" message.\n" +
                        "" +
                        "Check these links for more \n" +
                        "https://developer.android.com/topic/performance/vitals/anr\n" +
                        " "));
        questionsAns.add(new QuestionAnswerModel(43, "What to avoid ANR ?",
                "We can avoid the ANR by Stop doing heavy jobs on main thread. Instead use worker threads such as IntentService, AsyncTask or another Thread.\n" +
                        "How To Solve?\n" +
                        "Strict Mode\n" +
                        "\n" +
                        "On the development phase you can use Strict Mode to identify accidental I/O operations.\n" +
                        "\n" +
                        "Developer Options\n" +
                        "\n" +
                        "Actually not all ANR’s are shown to user. But at Developer Options of Settings, there is an option “Show All ANRs”. If this option is selected, Android OS will show you internal ANRs also.\n" +
                        "\n" +
                        "TraceView\n" +
                        "\n" +
                        "Android Studio has an inbuilt tool called TraceView. You can see memory and CPU usage of your app. For how to user TracevView, please refer to here.\n" +
                        "\n" +
                        "Inspect Traces File\n" +
                        "\n" +
                        "When ANR happens, Android logs some info related to the case in a txt file on device itself. You can use ADB to gather logs and have a look."));
        questionsAns.add(new QuestionAnswerModel(44, "What is Application Class ?",
                "The Application class in Android is the base class within an Android app that contains all other components such as activities and services. The Application class, or any subclass of the Application class, is instantiated before any other class when the process for your application/package is created.\n" +
                        "This class is primarily used for initialization of global state before the first Activity is displayed. Note that custom Application objects should be used carefully and are often not needed at all.\n" +
                        "for information please visit \n" +
                        "https://github.com/codepath/android_guides/wiki/Understanding-the-Android-Application-Class"));
        questionsAns.add(new QuestionAnswerModel(45, "What is services in android ?",
                "A Service is an application component that can perform long-running operations in the background, and it doesn't provide a user interface. Another application component can start a service, and it continues to run in the background even if the user switches to another application. Additionally, a component can bind to a service to interact with it and even perform interprocess communication (IPC). For example, a service can handle network transactions, play music, perform file I/O, or interact with a content provider, all from the background." +
                        "\n" +
                        "There are three kind of services namely :\n" +
                        "1.Foreground\n" +
                        "A foreground service performs some operation that is noticeable to the user. For example, an audio app would use a foreground service to play an audio track. Foreground services must display a Notification. Foreground services continue running even when the user isn't interacting with the app.\n" +
                        "2.Background\n" +
                        "A background service performs an operation that isn't directly noticed by the user. For example, if an app used a service to compact its storage, that would usually be a background service.\n" +
                        "Bound\n" +
                        "A service is bound when an application component binds to it by calling bindService(). A bound service offers a client-server interface that allows components to interact with the service, send requests, receive results, and even do so across processes with interprocess communication (IPC). A bound service runs only as long as another application component is bound to it. Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed."));
        questionsAns.add(new QuestionAnswerModel(46,"How to choose between a service and thread ?",
                "If you must perform work outside of your main thread, but only while the user is interacting with your application, you should instead create a new thread. For example, if you want to play some music, but only while your activity is running, you might create a thread in onCreate(), start running it in onStart(), and stop it in onStop(). Also consider using AsyncTask or HandlerThread instead of the traditional Thread class.\n" +
                        "\n" +
                        "Remember that if you do use a service, it still runs in your application's main thread by default, so you should still create a new thread within the service if it performs intensive or blocking operations.\n"));
        questionsAns.add(new QuestionAnswerModel(47,"What is the difference between Service and IntentService ?",
                "The main difference between the service and IntentService is , Service class doesn't provide the Thread implementation for you and you are responsible creating the background thread and stopping the service by calling stopService() or stopSelf() method. On the other hand Intent \n" +
                        "service provides a background thread for you and invokes the callback onHandleIntent(intent). If another thread is delivered to this service before \n" +
                        "the worker thread has completed the earlier intent, the new intent will sit and wait.\n" +
                        "Once all the intents are processed, the service will stop itself."));
        questionsAns.add(new QuestionAnswerModel(48,"What are the different components or context from which a service can be binded ?",
                "Binding is allowed from an Application Context, an Activity, another service or Content Provider but NOT from Fragment and BroadcastReceiver."));
        questionsAns.add(new QuestionAnswerModel(49,"What is Local Service and Remote Service ?",
                "Local Service : The Service which is only accessible to the application that is hosting it, and not accessible from other application installed on the device is know as Local Service. It can be initialized by bindService() or startService().\n\n" +
                        "Remote Service : These are accessible by external application. We defines the Remote services using Android Interface Definition Language(AIDL). It supports RPC call. It is always initialized by bindService()"));
        questionsAns.add(new QuestionAnswerModel(50,"How to create a Service ?",
                "The service create pattern is as follow : \n" +
                        "1. Create a class and extends to Service class.\n" +
                        "2. Create a Worker Thread Runnable \n" +
                        "3. Attach the Worker thread to Service in background service\n" +
                        "4. Start the service.\n" +
                        "Visit this link for implementation details \n" +
                        "https://developer.android.com/training/run-background-service/create-service"));
        questionsAns.add(new QuestionAnswerModel(51,"What is AsyncTask ?",
                "Android AsyncTask is an abstract class provided by Android which gives us the liberty to perform heavy tasks in the background and keep the UI thread light thus making the application more responsive.\n" +
                        "Android application runs on a single thread when launched. Due to this single thread model tasks that take longer time to fetch the response can make the application non-responsive. To avoid this we use android AsyncTask to perform the heavy tasks in background on a dedicated thread and passing the results back to the UI thread. Hence use of AsyncTask in android application keeps the UI thread responsive at all times.\n" +
                        "For more information please visit : \n" +
                        "https://www.journaldev.com/9708/android-asynctask-example-tutorial"));
        questionsAns.add(new QuestionAnswerModel(52,"What will happen if we execute two AsyncTask one after each ? ",
                "When first introduced, AsyncTasks were executed serially on a single background thread. Starting with Build.VERSION_CODES.DONUT, this was changed to a pool of threads allowing multiple tasks to operate in parallel. Starting with Build.VERSION_CODES.HONEYCOMB, tasks are executed on a single thread to avoid common application errors caused by parallel execution. So it is not valid to call task.execute() more than one.\n" +
                        "\n" +
                        "If you truly want parallel execution, you can invoke executeOnExecutor(java.util.concurrent.Executor, java.lang.Object[]) with THREAD_POOL_EXECUTOR.\n" +
                        "For more information please visit :\n" +
                        "https://stackoverflow.com/a/4072832/5163725"));
        questionsAns.add(new QuestionAnswerModel(53,"What is managed dialogs ?",
                "The dialogs which can be recreated with the Activity creation is called the managed dialogs."));
        questionsAns.add(new QuestionAnswerModel(56,"What are the new Features in Android 8.0(API 26) ?",
                "There is a major update in android 8.0+, some features are listed as follow : \n" +
                        "1.Picture in Picture (PIP) - Special type of multi-window feature, Mainly used for video playbacks.\n" +
                        "When activity is in PIP mode, it is in paused state, but should continue showing the content.\n" +
                        "2.A Major update in Notifications :" +
                        "   -Notification Channel\n" +
                        "   -Notification dots\n" +
                        "   -Snoozing\n" +
                        "   -Notification timeout\n" +
                        "   -Notification Setting\n" +
                        "   -Notification Dismissal\n" +
                        "   -Background Colors\n" +
                        "\n" +
                        "3.AutoFill Frameworks : Account creation, login, and credit card transactions take time and are prone to errors. Users can easily get frustrated with apps that require these types of repetitive tasks.\n" +
                        "4.Downloadable fonts : Android Support Library 26 let you request fonts from a provider application instead of bundling fonts into the APK or letting the APK download fonts. This feature reduces your APK size, increases the app installation success rate, and allows multiple apps to share the same font.\n" +
                        "5.Fonts in XML\n" +
                        "6.Autosizing TextView\n" +
                        "7.Adaptive icons\n" +
                        "8.Color management\n" +
                        "9.WebView APIs\n" +
                        "10.Pinning shortcuts and widgets\n" +
                        "11.Maximum screen aspect ratio\n" +
                        "12.Multi-display support\n" +
                        "13.Unified layout margins and padding\n" +
                        "14.App categories\n" +
                        "15.AnimatorSet\n" +
                        "16.Input Animation\n" +
                        "and so on.... please visit this to see all explanation : \n" +
                        "https://developer.android.com/about/versions/oreo/android-8.0"));
        questionsAns.add(new QuestionAnswerModel(57,"What are the background execution limits in 8.0 ?",
                "c. The more apps are running at once, the more load is placed on the system. If additional apps or services are running in the background, this places additional loads on the system, which could result in a poor user experience; for example, the music app might be suddenly shut down.\n" +
                        "\n" +
                        "To lower the chance of these problems, Android 8.0 places limitations on what apps can do while users aren't directly interacting with them. Apps are restricted in two ways:\n" +
                        "\n" +
                        "Background Service Limitations: While an app is idle, there are limits to its use of background services. This does not apply to foreground services, which are more noticeable to the user.\n" +
                        "\n" +
                        "Broadcast Limitations: With limited exceptions, apps cannot use their manifest to register for implicit broadcasts. They can still register for these broadcasts at runtime, and they can use the manifest to register for explicit broadcasts targeted specifically at their app.\n" +
                        "\nVisit this for more info : \n" +
                        "https://developer.android.com/about/versions/oreo/background"));
        questionsAns.add(new QuestionAnswerModel(58,"What are latest feature in Android Oreo Go(8.1) api 27 ?",
                "These are the different features in 8.1+ \n" +
                        "Android Go : Android Go is our initiative to optimize the Android experience for billions of people coming online around the world. Starting with Android 8.1, we’re making Android a great platform for entry-level devices.\n" +
                        "Neural Network API \n" +
                        "Autofill framework is also updated\n" +
                        "EditText update : Beginning with API level 27, the EditText.getText() method returns an Editable; previously it returned a CharSequence. This change is backward-compatible, as Editable implements CharSequence.\n" +
                        "\n" +
                        "The Editable interface provides valuable additional functionality. For example, because Editable also implements the Spannable interface, you can apply markup to content within an instance of EditText.\n" +
                        "\nSafe Browsing\n" +
                        "Shared Memory APIs and WallpaperColor APIs are addedn\n" +
                        "Fingerprint Updates and \n" +
                        "Cryptographic Updates are added, visit the below link for detailed explanation..\n" +
                        "https://developer.android.com/about/versions/oreo/android-8.1"));
        questionsAns.add(new QuestionAnswerModel(59,"What are new fetures of android pie (9.0) API 28 ?",
                "Visit the link....\n" +
                        "https://developer.android.com/about/versions/pie/android-9.0"));
        questionsAns.add(new QuestionAnswerModel(60,"",""));
        questionsAns.add(new QuestionAnswerModel(61,"",""));
        questionsAns.add(new QuestionAnswerModel(62,"",""));
        questionsAns.add(new QuestionAnswerModel(63,"",""));
        questionsAns.add(new QuestionAnswerModel(64,"",""));
        questionsAns.add(new QuestionAnswerModel(65,"",""));
        questionsAns.add(new QuestionAnswerModel(66,"",""));
        questionsAns.add(new QuestionAnswerModel(67,"",""));
        questionsAns.add(new QuestionAnswerModel(68,"",""));
        questionsAns.add(new QuestionAnswerModel(69,"",""));
        questionsAns.add(new QuestionAnswerModel(70,"",""));
        questionsAns.add(new QuestionAnswerModel(71,"",""));
        questionsAns.add(new QuestionAnswerModel(72,"",""));
        questionsAns.add(new QuestionAnswerModel(73,"",""));
        questionsAns.add(new QuestionAnswerModel(74,"",""));
        questionsAns.add(new QuestionAnswerModel(75,"",""));
        questionsAns.add(new QuestionAnswerModel(76,"",""));
        questionsAns.add(new QuestionAnswerModel(77,"",""));
        questionsAns.add(new QuestionAnswerModel(78,"",""));
        questionsAns.add(new QuestionAnswerModel(79,"",""));
        questionsAns.add(new QuestionAnswerModel(80,"",""));
        questionsAns.add(new QuestionAnswerModel(81,"",""));
        questionsAns.add(new QuestionAnswerModel(82,"",""));
        questionsAns.add(new QuestionAnswerModel(83,"",""));
        questionsAns.add(new QuestionAnswerModel(84,"",""));
        questionsAns.add(new QuestionAnswerModel(85,"",""));
        questionsAns.add(new QuestionAnswerModel(86,"",""));
        questionsAns.add(new QuestionAnswerModel(87,"",""));
        questionsAns.add(new QuestionAnswerModel(88,"",""));
        questionsAns.add(new QuestionAnswerModel(89,"",""));
        questionsAns.add(new QuestionAnswerModel(90,"",""));
        questionsAns.add(new QuestionAnswerModel(91,"",""));
        questionsAns.add(new QuestionAnswerModel(92,"",""));
        questionsAns.add(new QuestionAnswerModel(93,"",""));
        questionsAns.add(new QuestionAnswerModel(94,"",""));
        questionsAns.add(new QuestionAnswerModel(95,"",""));
        questionsAns.add(new QuestionAnswerModel(96,"",""));
        questionsAns.add(new QuestionAnswerModel(97,"",""));
        questionsAns.add(new QuestionAnswerModel(98,"",""));
        questionsAns.add(new QuestionAnswerModel(99,"",""));
        questionsAns.add(new QuestionAnswerModel(100,"",""));
    }
}
