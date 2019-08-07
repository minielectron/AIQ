package com.androidcodeshop.aiq.utils;

import com.androidcodeshop.aiq.model.QuestionAnswerModel;

import java.util.ArrayList;

public class Questions {
    private static ArrayList<QuestionAnswerModel> questionsAns;

    private Questions() {
    }

    public static ArrayList<QuestionAnswerModel> getInstance() {
        if (questionsAns == null) {
            questionsAns = new ArrayList<>();
            populateQuestions();
        }
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
        questionsAns.add(new QuestionAnswerModel(19, "How to write Html in string ?", "" +
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

        questionsAns.add(new QuestionAnswerModel(29, "What is REALM Database ?",
                "Realm is a lightweight database that can replace both SQLite and ORM libraries in your Android projects. Compared to SQLite, Realm is faster and has lots of modern features, such as JSON support, a fluent API, data change notifications, and encryption support, all of which make life easier for Android developers.\n" +
                        "" +
                        "\n Visit the link for more \n" +
                        "https://realm.io/"));
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
        questionsAns.add(new QuestionAnswerModel(36, "How to communicate between two fragments ?",
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
        questionsAns.add(new QuestionAnswerModel(46, "How to choose between a service and thread ?",
                "If you must perform work outside of your main thread, but only while the user is interacting with your application, you should instead create a new thread. For example, if you want to play some music, but only while your activity is running, you might create a thread in onCreate(), start running it in onStart(), and stop it in onStop(). Also consider using AsyncTask or HandlerThread instead of the traditional Thread class.\n" +
                        "\n" +
                        "Remember that if you do use a service, it still runs in your application's main thread by default, so you should still create a new thread within the service if it performs intensive or blocking operations.\n"));
        questionsAns.add(new QuestionAnswerModel(47, "What is the difference between Service and IntentService ?",
                "The main difference between the service and IntentService is , Service class doesn't provide the Thread implementation for you and you are responsible creating the background thread and stopping the service by calling stopService() or stopSelf() method. On the other hand Intent" +
                        "service provides a background thread for you and invokes the callback onHandleIntent(intent). If another thread is delivered to this service before \n" +
                        "the worker thread has completed the earlier intent, the new intent will sit and wait.\n" +
                        "Once all the intents are processed, the service will stop itself."));
        questionsAns.add(new QuestionAnswerModel(48, "What are the different components or context from which a service can be binded ?",
                "Binding is allowed from an Application Context, an Activity, another service or Content Provider but NOT from Fragment and BroadcastReceiver."));
        questionsAns.add(new QuestionAnswerModel(49, "What is Local Service and Remote Service ?",
                "Local Service : The Service which is only accessible to the application that is hosting it, and not accessible from other application installed on the device is know as Local Service. It can be initialized by bindService() or startService().\n\n" +
                        "Remote Service : These are accessible by external application. We defines the Remote services using Android Interface Definition Language(AIDL). It supports RPC call. It is always initialized by bindService()"));
        questionsAns.add(new QuestionAnswerModel(50, "How to create a Service ?",
                "The service create pattern is as follow : \n" +
                        "1. Create a class and extends to Service class.\n" +
                        "2. Create a Worker Thread Runnable \n" +
                        "3. Attach the Worker thread to Service in background service\n" +
                        "4. Start the service.\n" +
                        "Visit this link for implementation details \n" +
                        "https://developer.android.com/training/run-background-service/create-service"));
        questionsAns.add(new QuestionAnswerModel(51, "What is AsyncTask ?",
                "Android AsyncTask is an abstract class provided by Android which gives us the liberty to perform heavy tasks in the background and keep the UI thread light thus making the application more responsive.\n" +
                        "Android application runs on a single thread when launched. Due to this single thread model tasks that take longer time to fetch the response can make the application non-responsive. To avoid this we use android AsyncTask to perform the heavy tasks in background on a dedicated thread and passing the results back to the UI thread. Hence use of AsyncTask in android application keeps the UI thread responsive at all times.\n" +
                        "For more information please visit : \n" +
                        "https://www.journaldev.com/9708/android-asynctask-example-tutorial"));
        questionsAns.add(new QuestionAnswerModel(52, "What will happen if we execute two AsyncTask one after each ? ",
                "When first introduced, AsyncTasks were executed serially on a single background thread. Starting with Build.VERSION_CODES.DONUT, this was changed to a pool of threads allowing multiple tasks to operate in parallel. Starting with Build.VERSION_CODES.HONEYCOMB, tasks are executed on a single thread to avoid common application errors caused by parallel execution. So it is not valid to call task.execute() more than one.\n" +
                        "\n" +
                        "If you truly want parallel execution, you can invoke executeOnExecutor(java.util.concurrent.Executor, java.lang.Object[]) with THREAD_POOL_EXECUTOR.\n" +
                        "For more information please visit :\n" +
                        "https://stackoverflow.com/a/4072832/5163725"));
        questionsAns.add(new QuestionAnswerModel(53, "What is managed dialogs ?",
                "The dialogs which can be recreated with the Activity creation is called the managed dialogs."));
        questionsAns.add(new QuestionAnswerModel(54, "What are the new Features in Android 8.0(API 26) ?",
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
        questionsAns.add(new QuestionAnswerModel(55, "What are the background execution limits in 8.0 ?",
                "c. The more apps are running at once, the more load is placed on the system. If additional apps or services are running in the background, this places additional loads on the system, which could result in a poor user experience; for example, the music app might be suddenly shut down.\n" +
                        "\n" +
                        "To lower the chance of these problems, Android 8.0 places limitations on what apps can do while users aren't directly interacting with them. Apps are restricted in two ways:\n" +
                        "\n" +
                        "Background Service Limitations: While an app is idle, there are limits to its use of background services. This does not apply to foreground services, which are more noticeable to the user.\n" +
                        "\n" +
                        "Broadcast Limitations: With limited exceptions, apps cannot use their manifest to register for implicit broadcasts. They can still register for these broadcasts at runtime, and they can use the manifest to register for explicit broadcasts targeted specifically at their app.\n" +
                        "\nVisit this for more info : \n" +
                        "https://developer.android.com/about/versions/oreo/background"));
        questionsAns.add(new QuestionAnswerModel(56, "What are latest feature in Android Oreo Go(8.1) api 27 ?",
                "These are the different features in 8.1+ \n" +
                        "1.Android Go : Android Go is our initiative to optimize the Android experience for billions of people coming online around the world. Starting with Android 8.1, we’re making Android a great platform for entry-level devices.\n" +
                        "2.Neural Network API \n" +
                        "3.Autofill framework is also updated\n" +
                        "4.EditText update : Beginning with API level 27, the EditText.getText() method returns an Editable; previously it returned a CharSequence. This change is backward-compatible, as Editable implements CharSequence.\n" +
                        "\n" +
                        "The Editable interface provides valuable additional functionality. For example, because Editable also implements the Spannable interface, you can apply markup to content within an instance of EditText.\n" +
                        "\n4.Safe Browsing\n" +
                        "5.Shared Memory APIs and WallpaperColor APIs are added\n" +
                        "6.Fingerprint Updates and \n" +
                        "7.Cryptographic Updates are added, visit the below link for detailed explanation..\n" +
                        "https://developer.android.com/about/versions/oreo/android-8.1"));
        questionsAns.add(new QuestionAnswerModel(57, "What are new features of android pie (9.0) API 28 ?",
                "Visit the link....\n" +
                        "https://developer.android.com/about/versions/pie/android-9.0"));
        questionsAns.add(new QuestionAnswerModel(58, "What is JobScheduler ? ",
                "This is an API for scheduling various types of jobs against the framework that will be executed in your application's own process.\n" +
                        "This works on system level and helps in scheduling jobs(task).\n" +
                        "visit the link to see more informations : \n" +
                        "https://medium.com/google-developers/scheduling-jobs-like-a-pro-with-jobscheduler-286ef8510129"));
        questionsAns.add(new QuestionAnswerModel(59, "What is an AlarmManager ? ",
                "Android AlarmManager allows you to access system alarm.\n" +
                        "\n" +
                        "By the help of Android AlarmManager in android, you can schedule your application to run at a specific time in the future. It works whether your phone is running or not.\n" +
                        "\n" +
                        "The Android AlarmManager holds a CPU wake lock that provides guarantee not to sleep the phone until broadcast is handled.\n" +
                        "\n" +
                        "visit for code implementation visit the link \n" +
                        "https://www.javatpoint.com/android-alarmmanager\n" +
                        "https://stackoverflow.com/questions/4459058/alarm-manager-example"));
        questionsAns.add(new QuestionAnswerModel(60, "What is content providers ?",
                "A content provides component supplies data from one application to other on request. Such request are handled by ContentResolver class.\n" +
                        "A Content provider can use different ways to store its data and the data can be stored in a database, in files, or even over a network.\n" +
                        "\nvisit the link for more information \n" +
                        "https://developer.android.com/guide/topics/providers/content-provider-basics"));
        questionsAns.add(new QuestionAnswerModel(61, "What is the limitations of AlarmManager ?",
                "It doesn't persist after phone reboot, this is the major limitation as well AlarmManager now doesn't gurantee the exact time alarm delivery because  OS will use this policy in order to \"batch\" alarms together across the entire system, minimizing the number of times the device needs to \"wake up\" and minimizing battery use. In general, alarms scheduled in the near future will not be deferred as long as alarms scheduled far in the future.\n" +
                        "We can persist our AlarmManager after reboot by using the BroadcastReceiver as follow:\n" +
                        "create a BroadCastReceiver which will start the Alarm while booting completes of the device.\n" +
                        "\n" +
                        "Use <action android:name=\"android.intent.action.BOOT_COMPLETED\" /> for trapping boot activity in BroadCastReceiver class.\n" +
                        "\n" +
                        "You need to add above line in AndroidManifest.xml as follows,\n" +
                        "\n" +
                        "<receiver android:name=\".AutoStartUp\" android:enabled=\"true\" android:exported=\"false\" android:permission=\"android.permission.RECEIVE_BOOT_COMPLETED\">\n" +
                        "     <intent-filter>\n" +
                        "        <action android:name=\"android.intent.action.BOOT_COMPLETED\" />\n" +
                        "    </intent-filter>\n" +
                        "</receiver>"));
        questionsAns.add(new QuestionAnswerModel(62, "What is ViewGroup in android ?",
                "A ViewGroup is a special view that can contain other views (called children.) The view group is the base class for layouts and views containers. This class also defines the ViewGroup.LayoutParams class which serves as the base class for layouts parameters.\n"));
        questionsAns.add(new QuestionAnswerModel(63, "What is difference between View and ViewGroup ?",
                "View\n" +
                        "   -View objects are the basic building blocks of User Interface(UI) elements in Android.\n" +
                        "   -View is a simple rectangle box which responds to the user's actions.\n" +
                        "   -Examples are EditText, Button, CheckBox etc..\n" +
                        "   -View refers to the android.view.View class, which is the base class of all UI classes.\n" +
                        "ViewGroup\n" +
                        "   -ViewGroup is the invisible container. It holds View and ViewGroup\n" +
                        "   -For example, LinearLayout is the ViewGroup that contains Button(View), and other Layouts also.\n" +
                        "   -ViewGroup is the base class for Layouts."));
        questionsAns.add(new QuestionAnswerModel(64, "What is intent Flags ?\n",
                "Flags defined in the Intent class that function as metadata for the intent. The flags may instruct the Android system how to launch an activity and how to treat it after it’s launched.\n" +
                        "The described behaviour can be modified by specifying intent flags on the intent instance before passing the intent to startActivity(Intent), for example:\n" +
                        "\n" +
                        "intent.addFlag(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);"));
        questionsAns.add(new QuestionAnswerModel(65, "What is SQLite?",
                "SQLite is an in-process library that implements a self-contained, serverless, zero-configuration, transactional SQL database engine. The code for SQLite is in the public domain and is thus free for use for any purpose, commercial or private. SQLite is the most widely deployed database in the world with more applications than we can count, including several high-profile projects.\n" +
                        "for more information please visit : \n" +
                        "https://www.sqlite.org/about.html"));
        questionsAns.add(new QuestionAnswerModel(66, "Who to use SQLite in android?",
                "Please visit this link : \n" +
                        "https://www.journaldev.com/9438/android-sqlite-database-example-tutorial"));
        questionsAns.add(new QuestionAnswerModel(67, "What is adb and how to use it?",
                "Android Debug Bridge (adb) is a versatile command-line tool that lets you communicate with a device. The adb command facilitates a variety of device actions, such as installing and debugging apps, and it provides access to a Unix shell that you can use to run a variety of commands on a device.\n" +
                        "\n" +
                        "It is located at android_sdk/platform-tools/. set the path before using the command else it will give commnad not found error.\n\n" +
                        "Usage : \n" +
                        "   1.To install the application use adb install [apk path], we can use different flags such as -r and -f\n" +
                        "   2.To uninstall adb uninstall package_name\n" +
                        "   3.To backup adb backup -all [backup path] and etc....\n" +
                        "for more info read this \n" +
                        "https://developer.android.com/studio/command-line/adb"));
        questionsAns.add(new QuestionAnswerModel(68, "What is WebView ?", "WebView is an Html rendering engine and used as replica of the WebKit(in apples phone). The idea was that this app could be updated independently of the\n" +
                "device firmware, so that WebView bugs could be fixed more rapidly and distributed to\n" +
                "more devices. This also means that Google can distribute new and exciting bugs\n" +
                "more quickly (and independently of Android OS version).\n "));
        questionsAns.add(new QuestionAnswerModel(69, "How to use WebView ? ",
                "The complete implementation of WebView to render the web pages is show below : \n" +
                        "\nXML File: \n" +
                        "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<FrameLayout xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "    xmlns:tools=\"http://schemas.android.com/tools\"\n" +
                        "    android:layout_width=\"match_parent\"\n" +
                        "    android:layout_height=\"match_parent\"\n" +
                        "    android:background=\"#0099cc\"\n" +
                        "    tools:context=\".activities.WebViewActivity\">\n" +
                        "        <WebView\n" +
                        "            android:id=\"@+id/web_view\"\n" +
                        "            android:layout_width=\"match_parent\"\n" +
                        "            android:layout_height=\"match_parent\"\n" +
                        "            android:gravity=\"center\"\n" +
                        "            android:keepScreenOn=\"true\" />\n" +
                        "        <ProgressBar\n" +
                        "            android:id=\"@+id/progress_bar\"\n" +
                        "            android:layout_gravity=\"center\"\n" +
                        "            android:layout_width=\"wrap_content\"\n" +
                        "            android:layout_height=\"wrap_content\" />\n" +
                        "</FrameLayout>\n\nJava File :" +
                        "\n\n" +
                        "import android.annotation.SuppressLint;\n" +
                        "import android.app.ActionBar;\n" +
                        "import android.content.Intent;\n" +
                        "import android.graphics.Bitmap;\n" +
                        "import android.os.Build;\n" +
                        "import android.os.Bundle;\n" +
                        "import android.support.v7.app.AppCompatActivity;\n" +
                        "import android.util.Xml;\n" +
                        "import android.view.KeyEvent;\n" +
                        "import android.view.View;\n" +
                        "import android.view.Window;\n" +
                        "import android.view.WindowManager;\n" +
                        "import android.webkit.WebView;\n" +
                        "import android.webkit.WebViewClient;\n" +
                        "import android.widget.ProgressBar;\n" +
                        "\n" +
                        "import com.wipro.gdms.R;\n" +
                        "import com.wipro.gdms.Utils.AppUtils;\n" +
                        "\n" +
                        "import butterknife.BindView;\n" +
                        "import butterknife.ButterKnife;\n" +
                        "import electrophile.mutils.MiniNetworkingUtils;\n" +
                        "import okio.Utf8;\n" +
                        "\n" +
                        "/**\n" +
                        " * An example full-screen activity that shows and hides the system UI (i.e.\n" +
                        " * status bar and navigation/system bar) with user interaction.\n" +
                        " */\n" +
                        "public class WebViewActivity extends AppCompatActivity {\n" +
                        "    private static final String DEFAULT_URL = \"https://www.androidcodeshop.com\";\n" +
                        "    @BindView(R.id.web_view)\n" +
                        "    WebView webView;\n" +
                        "    @BindView(R.id.progress_bar)\n" +
                        "    ProgressBar progressBar;\n" +
                        "    @SuppressLint(\"SetJavaScriptEnabled\")\n" +
                        "    @Override\n" +
                        "    protected void onCreate(Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.activity_web_view);\n" +
                        "        ButterKnife.bind(this);\n" +
                        "        AppUtils.makeActivityFullScreen(getWindow());\n" +
                        "        // check the internet connection\n" +
                        "        if (MiniNetworkingUtils.isConnected(this)) {\n" +
                        "\n" +
                        "            String url = DEFAULT_URL;\n" +
                        "            Intent intent = getIntent();\n" +
                        "            if (intent != null) {\n" +
                        "                url = intent.getStringExtra(\"url\");\n" +
                        "            }\n" +
                        "            webView.setWebViewClient(new WebViewClient() {\n" +
                        "                @Override\n" +
                        "                public boolean shouldOverrideUrlLoading(WebView view, String request) {\n" +
                        "                    view.loadUrl(request);\n" +
                        "                    return super.shouldOverrideUrlLoading(view, request);\n" +
                        "                }\n" +
                        "\n" +
                        "                @Override\n" +
                        "                public void onPageFinished(WebView view, String url) {\n" +
                        "                    super.onPageFinished(view, url);\n" +
                        "                    progressBar.setVisibility(View.INVISIBLE);\n" +
                        "                }\n" +
                        "\n" +
                        "                @Override\n" +
                        "                public void onPageStarted(WebView view, String url, Bitmap favicon) {\n" +
                        "                    super.onPageStarted(view, url, favicon);\n" +
                        "                    progressBar.setVisibility(View.VISIBLE);\n" +
                        "                }\n" +
                        "            });\n" +
                        "            webView.getSettings().setJavaScriptEnabled(true);\n" +
                        "            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {\n" +
                        "                webView.getSettings().setSafeBrowsingEnabled(true);\n" +
                        "            }\n" +
                        "            webView.loadUrl(url);\n" +
                        "        } else{\n" +
                        "            webView.loadData(\"<html>\" +\n" +
                        "                    \"<body><b>Internet connection is not available</b></body>\" +\n" +
                        "                    \"</html>\", \"text/html; charset-UTF-8\", null);\n" +
                        "            progressBar.setVisibility(View.INVISIBLE);\n" +
                        "        }\n" +
                        "\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public boolean onKeyDown(int keyCode, KeyEvent event) {\n" +
                        "        if (event.getAction() == KeyEvent.ACTION_DOWN) {\n" +
                        "            switch (keyCode) {\n" +
                        "                case KeyEvent.KEYCODE_BACK:\n" +
                        "                    if (webView.canGoBack()) {\n" +
                        "                        webView.goBack();\n" +
                        "                    } else {\n" +
                        "                        finish();\n" +
                        "                    }\n" +
                        "                    return true;\n" +
                        "            }\n" +
                        "\n" +
                        "        }\n" +
                        "        return super.onKeyDown(keyCode, event);\n" +
                        "    }\n" +
                        "\n" +
                        "}\n"));
        questionsAns.add(new QuestionAnswerModel(70, "What is Style in android ?",
                "Styles.xml is a file in android which contains styles, a style is an set of grouped attributes " +
                        "which is intended to be used repeatedly to apply that attribute group in different views and android elements. \n" +
                        "Example : \n" +
                        "<Button xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                        "   android:id=\"@+id/button\"\n" +
                        "   android:text=\"\"\n" +
                        "   android:layout_width=\"match_parent\"\n" +
                        "   android:layout_height=\"match_parent\"\n" +
                        "   style=\"@style/bigred\"\n" +
                        "   />\n" +
                        "" +
                        "In this bigred is style and it is declared as follows : \n" +
                        "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                        "<resources>\n" +
                        "   <style name=\"bigred\">\n" +
                        "       <item name=\"android:textSize\">30sp</item>\n" +
                        "       <item name=\"android:textColor\">#FFFF0000</item>\n" +
                        "   </style>\n" +
                        "</resources>"));
        questionsAns.add(new QuestionAnswerModel(71, "Where a style can be applied ?", "A Style can be appplied to elements(views) to only affect that widget. \n" +
                "It can be applied to the viewGroups also but it wont affect the childs(That is it won't style the children.)"));
        questionsAns.add(new QuestionAnswerModel(72, "How does android understands which layout file is to be shown ?",
                "There is an manifest file which holds all the configuration related to the application, all the activities are listed in the manifest files with action or name, Os loads the activity" +
                        ", Activity contains onCreate() which call the setContentView() from Activity which takes the layout as parameter and thus display the layout when the particular activity is loaded."));
        questionsAns.add(new QuestionAnswerModel(73, "What is intent ?",
                "An Intent is a messaging object you can use to request an action from another app component. Intents are mainly used for :\n" +
                        "1.Starting an Activity\n" +
                        "2.Starting a Service\n" +
                        "3.Sending s Broadcast\n" +
                        "4.Passing data between activities etc\n" +
                        "for more info go to : " +
                        "\nhttps://developer.android.com/guide/components/intents-filters"));
        questionsAns.add(new QuestionAnswerModel(74, "What are the different types of intents in android?",
                "There are two types of intents:\n" +
                        "\n" +
                        "1.Explicit intents specify which application will satisfy the intent, by supplying either the target app's package name or a fully-qualified component class name. You'll typically use an explicit intent to start a component in your own app, because you know the class name of the activity or service you want to start. For example, you might start a new activity within your app in response to a user action, or start a service to download a file in the background.\n" +
                        "\n\n2.Implicit intents do not name a specific component, but instead declare a general action to perform, which allows a component from another app to handle it. For example, if you want to show the user a location on a map, you can use an implicit intent to request that another capable app show a specified location on a map."));
        questionsAns.add(new QuestionAnswerModel(75, "What is Material Design ?",
                "Material is an adaptable system of guidelines, components, and tools that support the best practices of user interface design. Backed by open-source code, Material streamlines collaboration between designers and developers, and helps teams quickly build beautiful products.\n" +
                        "Material Design is a visual language that synthesizes the classic principles of good design with the innovation of technology and science.\n" +
                        "Material is a metaphor used to describe how things behaves, thier shadow, motion, texture , making cross platform applications, etc\n" +
                        "For more visit : https://material.io/design/ "));
        questionsAns.add(new QuestionAnswerModel(76, "What is an intent filter?",
                "An intent filter is an expression in an app's manifest file that specifies the type of intents that the component would like to receive." +
                        " For instance, by declaring an intent filter for an activity, you make it possible for other apps to directly start your " +
                        "activity with a certain kind of intent. Likewise, if you do not declare any intent filters for an activity, then it can be" +
                        " started only with an explicit intent."));
        questionsAns.add(new QuestionAnswerModel(77, "How does implicit intent works?",
                "When you use an implicit intent, the Android system finds the appropriate component to start by comparing the contents" +
                        " of the intent to the intent filters declared in the manifest file of other apps on the device. If the intent matches an intent filter, the system starts that component and delivers it the Intent object." +
                        " If multiple intent filters are compatible, the system displays a dialog so the user can pick which app to use."));
        questionsAns.add(new QuestionAnswerModel(78, "What are the different contents of Intent ?",
                "The intent contains these informations : \n" +
                        "1.Component Name : The name of the component to start. if component name is provided it makes intent an explicit intent,\n" +
                        " If you need to start a specific component in your app, you should specify the component name.\n\n" +
                        "2.Action : " +
                        "A string that specifies the generic action to perform (such as view or pick).You can specify the action for an intent with setAction() or with an Intent constructor.\n\n" +
                        "3.Data : It holds URI data such as MIME type to be shared across components.\n\n" +
                        "4.Category : A string containing additional information about the kind of component that should handle the intent. Any number of category descriptions can be placed in an intent, but most intents do not require a category. \n\n" +
                        "5.Extras : There are the key-value pairs of data or information required to accomplish the requested action.\n\n" +
                        "6.Flags : Flags are defined in the Intent class that function as metadata for the intent. \n\n" +
                        "Example : \n\n" +
                        "// Create the text message with a string\n" +
                        "Intent sendIntent = new Intent();\n" +
                        "sendIntent.setAction(Intent.ACTION_SEND);\n" +
                        "sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);\n" +
                        "sendIntent.setType(\"text/plain\");\n" +
                        "\n" +
                        "// Verify that the intent will resolve to an activity\n" +
                        "if (sendIntent.resolveActivity(getPackageManager()) != null) {\n" +
                        "    startActivity(sendIntent);\n" +
                        "}"));
        questionsAns.add(new QuestionAnswerModel(79, "What is chooser in intent context? ",
                "When there is more than one app that responds to your implicit intent, the user can select which app to use and make that app the default choice for the action. The ability to select a default is helpful when performing an action for which the user probably wants to use the same app every time, such as when opening a web page.\n\n"));
        questionsAns.add(new QuestionAnswerModel(80, "How to force intent to create chooser always ?",
                "To show the chooser, create an Intent using createChooser() and pass it to startActivity(), as shown in the following example. This example displays a dialog with a list of apps that respond to the intent passed to the createChooser() method and uses the supplied text as the dialog title.\n\n" +
                        "Intent sendIntent = new Intent(Intent.ACTION_SEND);\n" +
                        "...\n" +
                        "\n" +
                        "// Always use string resources for UI text.\n" +
                        "// This says something like \"Share this photo with\"\n" +
                        "String title = getResources().getString(R.string.chooser_title);\n" +
                        "// Create intent to show the chooser dialog\n" +
                        "Intent chooser = Intent.createChooser(sendIntent, title);\n" +
                        "\n" +
                        "// Verify the original intent will resolve to at least one activity\n" +
                        "if (sendIntent.resolveActivity(getPackageManager()) != null) {\n" +
                        "    startActivity(chooser);\n" +
                        "}"));
        questionsAns.add(new QuestionAnswerModel(81, "How to receive an implicit intent ?",
                "To receive the implicit intents in your app components you have to declare one or more intent-filters in your manifest.\n" +
                        "Each intent filter specifies the type of intents it accepts based on the intent's action, data, and category. \n" +
                        "For example, here's an activity declaration with an intent filter to receive an ACTION_SEND intent when the data type is text:\n" +
                        "\n" +
                        "<activity android:name=\"ShareActivity\">\n" +
                        "    <intent-filter>\n" +
                        "        <action android:name=\"android.intent.action.SEND\"/>\n" +
                        "        <category android:name=\"android.intent.category.DEFAULT\"/>\n" +
                        "        <data android:mimeType=\"text/plain\"/>\n" +
                        "    </intent-filter>\n" +
                        "</activity>\n\n" +
                        "An implicit intent is tested against a filter by comparing the intent to each of the three elements. To be delivered to the component, the intent must pass all three tests. If it fails to match even one of them, the Android system won't deliver the intent to the component. However, because a component may have multiple intent " +
                        "filters, an intent that does not pass through one of a component's filters might make it through on another filter. "));
        questionsAns.add(new QuestionAnswerModel(82, "What is PendingIntent ?",
                "A PendingIntent object is a wrapper around an Intent object. The primary purpose of a PendingIntent is to grant permission to a foreign application to use the contained Intent as if it were executed from your app's own process.\n\n" +
                        "Use of pending intent : \n" +
                        "1.Declaring an intent to be executed when the user performs an action with your Notification\n" +
                        "2.Declaring an intent to be executed when the user performs an action with your App Widget\n" +
                        "3.Declaring an intent to be executed at a specified future time\n" +
                        " When using a pending intent, your app doesn't execute the intent with a call such as startActivity(). Instead, you must declare the intended component type when you create the PendingIntent by calling the respective creator method:\n" +
                        "\n" +
                        "PendingIntent.getActivity() for an Intent that starts an Activity.\n" +
                        "PendingIntent.getService() for an Intent that starts a Service.\n" +
                        "PendingIntent.getBroadcast() for an Intent that starts a BroadcastReceiver."));
        questionsAns.add(new QuestionAnswerModel(83, "What is intent resolution ?",
                "When the system receives an implicit intent to start an activity, it searches for the best activity for the intent by comparing it to intent filters based on three aspects:\n" +
                        "\n" +
                        "Action.\n" +
                        "Data (both URI and data type).\n" +
                        "Category.\n" +
                        "If all three matches then only the intent get delivered."));
        questionsAns.add(new QuestionAnswerModel(84, "How do you implement google new material design in android application?",
                "Material design is about color customization, typography, Iconography, shape , motion and Interaction. Google also provide the Material design Widgets such as MaterialButton, TextInputEditText, TextInputLayout etc.\n" +
                        "To use the material widgets in android application you have to use android design support library(com.android.support:design:28.0.0) or new androidx material design library(com.google.android.material:material:1.0.0). \n" +
                        "For detailed explaination visit : https://material.io/design/"));
        questionsAns.add(new QuestionAnswerModel(85, "What is ListView?",
                "A list view is an adapter view that does not know the details, such as type and contents, of the views it contains. Instead list view requests views on demand from a ListAdapter as needed, such as to display new views as the user scrolls up or down.\n" +
                        "Usage : \n" +
                        "<ListView\n" +
                        "      android:id=\"@+id/list_view\"\n" +
                        "      android:layout_width=\"match_parent\"\n" +
                        "      android:layout_height=\"match_parent\" />\n" +
                        "After this create the adapter as per your view and set the adapter using the method setAdapter(Adapter)"));
        questionsAns.add(new QuestionAnswerModel(86, "What are the advantages of using recyclerview compared to listview ?",
                "With the advent of Android Lollipop, the RecyclerView made its way officially. The RecyclerView is much more powerful, flexible and a major enhancement over ListView. I will try to give you a detailed insight into it.\n" +
                        "\n" +
                        "Advantages\n" +
                        "\n" +
                        "1) ViewHolder Pattern\n" +
                        "\n" +
                        "In a ListView, it was recommended to use the ViewHolder pattern but it was never a compulsion. In case of RecyclerView, this is mandatory using the RecyclerView.ViewHolder class. This is one of the major differences between the ListView and the RecyclerView.\n" +
                        "\n" +
                        "It makes things a bit more complex in RecyclerView but a lot of problems that we faced in the ListView are solved efficiently.\n" +
                        "\n" +
                        "2) LayoutManager\n" +
                        "\n" +
                        "This is another massive enhancement brought to the RecyclerView. In a ListView, the only type of view available is the vertical ListView. There is no official way to even implement a horizontal ListView.\n" +
                        "\n" +
                        "Now using a RecyclerView, we can have a\n" +
                        "\n" +
                        "i) LinearLayoutManager - which supports both vertical and horizontal lists,\n" +
                        "\n" +
                        "ii) StaggeredLayoutManager - which supports Pinterest like staggered lists,\n" +
                        "\n" +
                        "iii) GridLayoutManager - which supports displaying grids as seen in Gallery apps.\n" +
                        "\n" +
                        "And the best thing is that we can do all these dynamically as we want.\n" +
                        "\n" +
                        "3) Item Animator\n" +
                        "\n" +
                        "ListViews are lacking in support of good animations, but the RecyclerView brings a whole new dimension to it. Using the RecyclerView.ItemAnimator class, animating the views becomes so much easy and intuitive.\n" +
                        "\n" +
                        "4) Item Decoration\n" +
                        "\n" +
                        "In case of ListViews, dynamically decorating items like adding borders or dividers was never easy. But in case of RecyclerView, the RecyclerView.ItemDecorator class gives huge control to the developers but makes things a bit more time consuming and complex.\n" +
                        "\n" +
                        "5) OnItemTouchListener\n" +
                        "\n" +
                        "Intercepting item clicks on a ListView was simple, thanks to its AdapterView.OnItemClickListener interface. But the RecyclerView gives much more power and control to its developers by the RecyclerView.OnItemTouchListener but it complicates things a bit for the developer.\n" +
                        "\n" +
                        "Disadvantages\n" +
                        "\n" +
                        "i) It is way more complex than a list view.\n" +
                        "\n" +
                        "ii) It can take a lot of time for a beginner to understand a RecyclerView fully.\n" +
                        "\n" +
                        "iii) It can unnecessarily make your coding life difficult.\n" +
                        "\n" +
                        "iv) You will need to spend much more time with it than you ever needed for a ListView\n" +
                        "reference : stackoverflow"));
        questionsAns.add(new QuestionAnswerModel(87, "What is the difference between android unit measure px, dip, dp, sp? ",
                "1.px\n" +
                        "Pixels - corresponds to actual pixels on the screen.\n" +
                        "2.pt\n" +
                        "Points - 1/72 of an inch based on the physical size of the screen.\n" +
                        "3.dp or dip\n" +
                        "Density-independent Pixels - an abstract unit that is based on the physical density of the screen. These units are relative to a 160 dpi screen, so one dp is one pixel on a 160 dpi screen. The ratio of dp-to-pixel will change with the screen density, but not necessarily in direct proportion. Note: The compiler accepts both \"dip\" and \"dp\", though \"dp\" is more consistent with \"sp\".\n" +
                        "4.sp\n" +
                        "Scale-independent Pixels - this is like the dp unit, but it is also scaled by the user's font size preference. It is recommended you use this unit when specifying font sizes, so they will be adjusted for both the screen density and user's preference.\n" +
                        "\n" +
                        "What to use?\n" +
                        "Use sp for Text size.\n" +
                        "\n" +
                        "Use dp for everything else."));
        questionsAns.add(new QuestionAnswerModel(88, "How to highlight the selcted item in the listview ?",
                "There is an xml attribute known as listSelector you can use that for higlighting the selected list item. You can also use colorStateList with listSelector." +
                        "\nUsage :android:listSelector=\"@android:color/transparent\""));
        questionsAns.add(new QuestionAnswerModel(89, "What is difference between toast and snackbar ?",
                " Toast : \n" +
                        "  1 | Can’t be dismissed by swiping \n" +
                        "  2 | Activity not required (Can show in android home or above other apps)\n" +
                        "  3 | Can’t handle user input\n" +
                        "  4 | Good for showing info messages to user\n\n" +
                        "SnackBar : \n" +
                        "  1 | Can dismiss by swiping\n" +
                        "  2 | Can show inside an activity of your app\n" +
                        "  3 | Can handle user input\n" +
                        "  4 | Good for showing warning/info type messages to user that needs attention. "

        ));
        questionsAns.add(new QuestionAnswerModel(90, "What is ListFragment ?",
                "A fragment that displays a list of items by binding to a data source such as an array or Cursor, and exposes event handlers when the user selects an item.\n" +
                        "\n" +
                        "ListFragment hosts a ListView object that can be bound to different data sources, typically either an array or a Cursor holding query results.\n" +
                        "Note : List Fragments are deprecated in the API 28."));
        questionsAns.add(new QuestionAnswerModel(91, "What is ListActivity ?",
                "An activity that displays a list of items by binding to a data source such as an array or Cursor, and exposes event handlers when the user selects an item.\n" +
                        "\n" +
                        "ListActivity hosts a ListView object that can be bound to different data sources, typically either an array or a Cursor holding query results. Binding, screen layout, and row layout.\n" +
                        ""));
        questionsAns.add(new QuestionAnswerModel(92, "Name some techologies that can be used to develop the android applications ?",
                "There are so many technologies and programming languages that we can use to develop the android application but the top five most popular techologies right now are : \n" +
                        "1.Kotlin\n" +
                        "2.Angular\n" +
                        "3.React\n" +
                        "4.Firebase\n" +
                        "5.Flutter\n" +
                        "there are others like figma, java etc."));
        questionsAns.add(new QuestionAnswerModel(93, "What is IntentService ?",
                "IntentService is a base class for Services that handle asynchronous requests (expressed as Intents) on demand. Clients send requests through Context.startService(Intent) calls; the service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.\n" +
                        "\n" +
                        "This \"work queue processor\" pattern is commonly used to offload tasks from an application's main thread. The IntentService class exists to simplify this pattern and take care of the mechanics. To use it, extend IntentService and implement onHandleIntent(android.content.Intent). IntentService will receive the Intents, launch a worker thread, and stop the service as appropriate\n" +
                        "For implemntation please visit :\n https://www.journaldev.com/20735/android-intentservice-broadcastreceiver"));
        questionsAns.add(new QuestionAnswerModel(94, "What is runtime permissions in android ?",
                "There are two kinds of permissions in android normal(Such as internet permission) and dangerous(R/W contacts). In android 6.0+( after Marshmallow )" +
                        "All the dangerous permissions needs to be declared in the manifest as well as you have to ask to user to grant those permissions at runtime. The permissions group affected by this are Calendar, Camera , Contacts, Locations, Microphone, Phone,Sensors, SMS and Storage total nine groups.\n" +
                        ""));
        questionsAns.add(new QuestionAnswerModel(95, "How do we know if we have required permission ?",
                "Android Context provides a method checkSelfPermission for 6.0+, we can use this to check if we have required permission or not. This method returns PERMISSION_GRANTED or PERMISSION_DENIED.\n" +
                        "for android below 6.0 we have v4 library support method ContextCompat.checkSelfPermission(). we can use this t check permissions in android below 6.0. "));
        questionsAns.add(new QuestionAnswerModel(96, "What will happen if some process is running and in between user take away the permission?",
                "The process checks the permission again and again if user takes away the permission in between then the application/process will be terminated. For example if a music player has storage permission and the process is running and in between user revoke the permission then the application will stop."));
        questionsAns.add(new QuestionAnswerModel(97, "How to ask permissions ?",
                "Activity has requestPermission() method which takes String array as parameter(input) with request code and triggers a method onRequestPermissionResult(int code, String[] permissions, int[] grantResults); we can use this method to request permission" +
                        "in android 6.0+. For android 6.0 below there is library support ActivityCompat.requestPermission(); "));
        questionsAns.add(new QuestionAnswerModel(98, "What will happen if configuration change during the permission request flow?",
                "If at the time of request flow configuration changes, it will result in asking the permission again. In this case you need to track whether you are in the permission flow(e.g via boolean variable on save instance state bundle) and stop requesting the permission if you have been recreated in the middle of the flow."));
        questionsAns.add(new QuestionAnswerModel(99, "What if user syas no to permission ?",
                "Take care of these points : \n" +
                        "1.Explain why you need that permission clearly." +
                        "2.Use shouldShowRequestPermissionRationale(permission) - this will return true if user has declined to grant your permission previously. you can give more information about why do you need that permission before calling the" +
                        "requestPermission().\n" +
                        ""));
        questionsAns.add(new QuestionAnswerModel(100, "What happens to the permissions when user clear the app data ?",
                "If user clear app data then the permissions will be reset and You need to ask them again."));
        questionsAns.add(new QuestionAnswerModel(102, "What is PermissionChecker ?",
                "The problem will the checkSelfPermission() method is that it returns always PERMISSION_GRANTED if either :" +
                        "1.Your app has targetSdkVersion below 23 or \n" +
                        "2.Your app is running on device older than android 6.0\n" +
                        "PermissionChecker class provides a static method checkPermission() which is used to resolve this problem.If you are on android 6.0+ with older targetSdkVersion, then it will return PERMISSION_DENIED_APP_OP if user revoked the permissions in settings."));
        questionsAns.add(new QuestionAnswerModel(103, "What is model fragment ?",
                "A model fragment is one that simply uses setRetainInstance(true) to ensure that it stick around as configuration changes. It has no UI. This fragments then holds onto any model data that its host activity needs," +
                        " so as that activity get destroyed and recreated, the model data sticks around in the model fragment.\n" +
                        "Google recommends the use of model fragments instead using the setRetainInstance(true) with regular fragment."));
        questionsAns.add(new QuestionAnswerModel(104, "Why should we use fragments instead of activities ?",
                "The fragments are more flexible then activities. We can reuse the UI of fragments in different places in same application. It helps in supporting wide ranges of screens size. The ViewPager also uses fragments as a page. Fragments can retain state of application. The user has more control over fragments."));
        questionsAns.add(new QuestionAnswerModel(105, "What are different types of fragments in android ?",
                "There are four types of fragments:\n" +
                        "\n" +
                        "ListFragment\n" +
                        "DialogFragment\n" +
                        "PreferenceFragment\n" +
                        "WebViewFragment\n" +
                        ""));
        questionsAns.add(new QuestionAnswerModel(106, "What is dialog fragment ?",
                "A fragment that displays a dialog window, floating on top of its activity's window. This fragment contains a Dialog object, which it displays as appropriate based on the fragment's state. Control of the dialog (deciding when to show, hide, dismiss it) should be done through the API here, not with direct calls on the dialog\n" +
                        "for detailed explaination and implementation visit: https://developer.android.com/reference/android/app/DialogFragment "));
        questionsAns.add(new QuestionAnswerModel(107, "How to embed a DialogFragment?",
                "To display a dialog as floating we use : \n" +
                        " DialogFragment newFragment = MyDialogFragment.newInstance();\n" +
                        "    newFragment.show(getFragmentManager(), \"dialog\");\n\n" +
                        "To embed the dialog to container : \n" +
                        "FragmentTransaction ft = getFragmentManager().beginTransaction();\n" +
                        "DialogFragment newFragment = MyDialogFragment.newInstance();\n" +
                        "ft.add(R.id.embedded, newFragment);\n" +
                        "ft.commit();"));
        questionsAns.add(new QuestionAnswerModel(108, "How to create an AlertDialog ?",
                "Instead of (or in addition to) implementing Fragment.onCreateView(LayoutInflater, ViewGroup, Bundle) to generate the view hierarchy inside of a dialog, you may implement onCreateDialog(android.os.Bundle) to create your own custom Dialog object.\n" +
                        "\n" +
                        "public static class MyAlertDialogFragment extends DialogFragment {\n" +
                        "\n" +
                        "    public static MyAlertDialogFragment newInstance(int title) {\n" +
                        "        MyAlertDialogFragment frag = new MyAlertDialogFragment();\n" +
                        "        Bundle args = new Bundle();\n" +
                        "        args.putInt(\"title\", title);\n" +
                        "        frag.setArguments(args);\n" +
                        "        return frag;\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public Dialog onCreateDialog(Bundle savedInstanceState) {\n" +
                        "        int title = getArguments().getInt(\"title\");\n" +
                        "\n" +
                        "        return new AlertDialog.Builder(getActivity())\n" +
                        "                .setIcon(R.drawable.alert_dialog_icon)\n" +
                        "                .setTitle(title)\n" +
                        "                .setPositiveButton(R.string.alert_dialog_ok,\n" +
                        "                    new DialogInterface.OnClickListener() {\n" +
                        "                        public void onClick(DialogInterface dialog, int whichButton) {\n" +
                        "                            ((FragmentAlertDialog)getActivity()).doPositiveClick();\n" +
                        "                        }\n" +
                        "                    }\n" +
                        "                )\n" +
                        "                .setNegativeButton(R.string.alert_dialog_cancel,\n" +
                        "                    new DialogInterface.OnClickListener() {\n" +
                        "                        public void onClick(DialogInterface dialog, int whichButton) {\n" +
                        "                            ((FragmentAlertDialog)getActivity()).doNegativeClick();\n" +
                        "                        }\n" +
                        "                    }\n" +
                        "                )\n" +
                        "                .create();\n" +
                        "    }\n" +
                        "}"));
        questionsAns.add(new QuestionAnswerModel(109, "What is annotations in java ?",
                "Annotations was introduced in java 5.0. \n" +
                        "One word to explain Annotation is Metadata. Metadata is data about data. So Annotations are metadata for code. For example look at following piece of code.\n" +
                        "\n" +
                        "@Override\n" +
                        "public String toString() {\n" +
                        "return \"This is String Representation of current object.\";\n" +
                        "}\n" +
                        "I have overridden the toString() method and used @Override annotation in above code. Even if I don’t put @Override, code works " +
                        "properly without any issue. So what’s the advantage and what does this annotation stand for? @Override tells the compiler that" +
                        " this method is an overridden method (metadata about method) and if any such method does not exist in parent class, then throw a " +
                        "compiler error (method does not override a method from its super class). Now if I would have made a typography mistake and used " +
                        "method name as toStrring() {double r} and if I wouldn’t have used @Override, my code would have compiled and executed successfully" +
                        " but outcome would be" +
                        " different from what I would have accepted. So now we understand what annotations are but still it’s good to read formal definitions"));
        questionsAns.add(new QuestionAnswerModel(110, "What is annotations in Android ?",
                "Android Annotations is an annotation-driven framework that allows you to simplify the code in your applications and reduces the boilerplate of common patterns, such as setting click listeners, enforcing ui/background thread executions, etc.\n" +
                        "\nLibraries such as ButterKnife, Dagger2 etc uses the annotations for generating the boilerplate code and makes developers life easy"));
        questionsAns.add(new QuestionAnswerModel(111, "How to create Custom Annotations ?",
                "Please visit the link for detailed explaination : \n" +
                        "https://medium.com/@iammert/annotation-processing-dont-repeat-yourself-generate-your-code-8425e60c6657"));
        questionsAns.add(new QuestionAnswerModel(112, "What is REST Api? ",
                "REST is acronym for REpresentational State Transfer. It is architectural style for distributed hypermedia systems and was first presented by Roy Fielding in 2000." +
                        "\n" +
                        "The six guiding pricipal of rest are : \n" +
                        "Client–server – By separating the user interface concerns from the data storage concerns, we improve the portability of the user interface across multiple platforms and improve scalability by simplifying the server components.\n" +
                        "Stateless – Each request from client to server must contain all of the information necessary to understand the request, and cannot take advantage of any stored context on the server. Session state is therefore kept entirely on the client.\n" +
                        "Cacheable – Cache constraints require that the data within a response to a request be implicitly or explicitly labeled as cacheable or non-cacheable. If a response is cacheable, then a client cache is given the right to reuse that response data for later, equivalent requests.\n" +
                        "Uniform interface – By applying the software engineering principle of generality to the component interface, the overall system architecture is simplified and the visibility of interactions is improved. In order to obtain a uniform interface, multiple architectural constraints are needed to guide the behavior of components. REST is defined by four interface constraints: identification of resources; manipulation of resources through representations; self-descriptive messages; and, hypermedia as the engine of application state.\n" +
                        "Layered system – The layered system style allows an architecture to be composed of hierarchical layers by constraining component behavior such that each component cannot “see” beyond the immediate layer with which they are interacting.\n" +
                        "Code on demand (optional) – REST allows client functionality to be extended by downloading and executing code in the form of applets or scripts. This simplifies clients by reducing the number of features required to be pre-implemented.\n" +
                        "for more info visit : https://restfulapi.net/"));
        questionsAns.add(new QuestionAnswerModel(113, "What is SOAP ?",
                "SOAP ( Simple Object Access Protocol) is a message protocol that allows distributed elements of an application to" +
                        " communicate. SOAP can be carried over a variety of lower-level protocols, including the web-related Hypertext Transfer" +
                        " Protocol (HTTP).  SOAP defines a header structure that identifies the actions that various SOAP nodes are expected to " +
                        "take on the message, in addition to a payload structure for carrying information. The concept of routing a message through a" +
                        " string of nodes that perform different functions is how SOAP supports things like addressing, security and format-independence."));
        questionsAns.add(new QuestionAnswerModel(114, "What is the difference between REST and SOAP ?",
                "REST : \n" +
                        "1.Representational State Transfer protocol\n" +
                        "2.Inherit security from underlying transport \n" +
                        "3.Error handeling mechanism provided\n" +
                        "4.Light weight and doesn't require XML Parsing\n" +
                        "5.Consumes less bandwidth\n" +
                        "6.Faster\n" +
                        "7.Result is simple(HTML or JSON)\n\n" +
                        "SOAP : \n" +
                        "1.Simple Object Access Protocol\n" +
                        "2.Defines own security\n" +
                        "3.No Error Handling\n" +
                        "4.XML Based Protocol\n" +
                        "5.Result is not human readable\n"));
        questionsAns.add(new QuestionAnswerModel(115, "What is deep links in android ?",
                "Deeplinks are a concept that help users navigate between the web and applications. They are basically URLs which navigate users directly to the specific content in applications.\n" +
                        "A deep link is an intent filter system that allows users to directly enter a specific activity in an Android app. However there is an issue about this process. When a user click an URL, it might open a dialog which asks the user to select one of multiple apps handling the given URL.\n"));
        questionsAns.add(new QuestionAnswerModel(116, "What is App Link in android ?",
                "Android App Links allow an app to designate itself as the default handler of application domain or URL. Unfortunately It works only on on Android 6.0 (API level 23) and higher.\n" +
                        ""));
        questionsAns.add(new QuestionAnswerModel(117, "What is the difference between deep links and app links?",
                "A deep link is an intent filter system that allows users to directly enter a specific activity in an Android app. However there is an issue about this process. When a user click an URL, it might open a dialog which asks the user to select one of multiple apps handling the given URL.\n" +
                        "\n" +
                        "On the other hand, An Android App Link is a deep link based on your website URL that has been verified to belong to your website. When user clicks that URL, it opens your app."));
        questionsAns.add(new QuestionAnswerModel(118, "What is android Jetpack ?",
                "Jetpack is a suite of libraries, tools, and guidance to help developers write high-quality apps easier. These components help you follow best practices, free you from writing boilerplate code, and simplify complex tasks, so you can focus on the code you care about.\n" +
                        "\n" +
                        "Jetpack comprises the androidx.* package libraries, unbundled from the platform APIs. This means that it offers backward compatibility and is updated more frequently than the Android platform, making sure you always have access to the latest and greatest versions of the Jetpack components."));
        questionsAns.add(new QuestionAnswerModel(119, "What are different Jetpack Components ?",
                "There are four jetpack components  :\n" +
                        "1.Foundation : Foundation components provide cross-cutting functionality like backwards compatibility, testing and Kotlin language support. It includes - Android KTX(kotlin support), AppCompat, Security, Mutlidex, Test etx.\n" +
                        "2.Architecture : Architecture components help you design robust, testable and maintainable apps. It includes - Data Binding, LiveData, Room, Paging, Navigation ViewModel, and WorkManager etc \n" +
                        "3.UI : Architecture components help you design robust, testable and maintainable apps. It includes - Animatation and transition, Emoji, Fragments, Layout and palette etc..\n" +
                        "4.Behaviour : Behavior components help your app integrate with standard Android services like notifications, permissions, sharing and the Assistant. It includex CameraX, Download Manager, Media, Permissions, Notification and so on."));
        questionsAns.add(new QuestionAnswerModel(120, "What is data binding ?",
                "The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.\n" +
                        "\n" +
                        "Layouts are often defined in activities with code that calls UI framework methods. For example, the code below calls findViewById() to find a TextView widget and bind it to the userName property of the viewModel variable:\n" +
                        "TextView textView = findViewById(R.id.sample_text);\n" +
                        "textView.setText(viewModel.getUserName());\n" +
                        "The above two lines can be replaced by :\n" +
                        "<TextView\n" +
                        "    android:text=\"@{viewmodel.userName}\" /> \n" +
                        "if we use data binding."));
        questionsAns.add(new QuestionAnswerModel(121, "What is Lifecycle components in Jetpack ?",
                "Lifecycle-aware components perform actions in response to a change in the lifecycle status of another component, such as activities and fragments. These components help you produce better-organized, and often lighter-weight code, that is easier to maintain.\n" +
                        "\n" +
                        "A common pattern is to implement the actions of the dependent components in the lifecycle methods of activities and fragments. However, this pattern leads to a poor organization of the code and to the proliferation of errors. By using lifecycle-aware components, you can move the code of dependent components out of the lifecycle methods and into the components themselves.\n" +
                        "\n" +
                        "The android.arch.lifecycle package provides classes and interfaces that let you build lifecycle-aware components—which are components that can automatically adjust their behavior based on the current lifecycle state of an activity or fragment.\n" +
                        "for more information visit : \n" +
                        "https://developer.android.com/topic/libraries/architecture/lifecycle"));
        questionsAns.add(new QuestionAnswerModel(122, "What is LiveData ?",
                "LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.\n" +
                        "For more info please visit : \n" +
                        "https://developer.android.com/topic/libraries/architecture/livedata"));

        questionsAns.add(new QuestionAnswerModel(123, "What are the mandatory functions to be implemented in AsyncTask?",
                "doInBackground() is the only mandatory function that has to be implemented in AsyncTask Class."));

        questionsAns.add(new QuestionAnswerModel(124, "What is AndroidX ?",
                "AndroidX is the open-source project that the Android team uses to develop, test, package, version and release libraries within Jetpack.\n" +
                        "\n" +
                        "AndroidX is a major improvement to the original Android Support Library. Like the Support Library, AndroidX ships separately from the Android OS and provides backwards-compatibility across Android releases. AndroidX fully replaces the Support Library by providing feature parity and new libraries.\n" +
                        "\n" +
                        "All packages in AndroidX live in a consistent namespace starting with the string androidx. The Support Library packages have been mapped into corresponding androidx.* packages. For a full mapping of all the old classes and build artifacts to the new ones, see the Package Refactoring page.\n" +
                        "\n" +
                        "Unlike the Support Library, AndroidX packages are separately maintained and updated. The androidx packages use strict Semantic Versioning starting with version 1.0.0. You can update AndroidX libraries in your project independently.\n" +
                        "\n" +
                        "All new Support Library development will occur in the AndroidX library. This includes maintenance of the original Support Library artifacts and introduction of new Jetpack components."));
        questionsAns.add(new QuestionAnswerModel(125, "What is Navigation in Jetpack ?",
                "Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of " +
                        "content within your app. Android Jetpack's Navigation component helps you implement navigation, from simple button clicks to more complex patterns, such as app bars and the navigation drawer." +
                        " The Navigation component also ensures a consistent and predictable user experience by adhering to an established set of principles.\n" +
                        "The Navigation component consists of three key parts that are described below:\n" +
                        "1.Navigation graph\n" +
                        "2.NavHost\n" +
                        "3.NavController\n" +
                        "For detailed information visit : \n" +
                        "https://developer.android.com/guide/navigation/"));
        questionsAns.add(new QuestionAnswerModel(126, "What is Room Persistence Library ?",
                "The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.\n" +
                        "\n" +
                        "The library helps you create a cache of your app's data on a device that's running your app. This cache, which serves as " +
                        "your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of " +
                        "whether users have an internet connection.\n" +
                        "For more information : \n" +
                        "https://codelabs.developers.google.com/codelabs/android-room-with-a-view/#0"));
        questionsAns.add(new QuestionAnswerModel(127, "What is AppCompat ?",
                "AppCompat is backward compatiblity library. " +
                        "Android users use a wide range of " +
                        "Android OS versions. While the changes from release to release may be small or may " +
                        "be large, the combined changes from older versions of Android to newer ones can be " +
                        "vast.\n" +
                        "AppCompat tries to help. It gives us an API for our activities and fragments that " +
                        "resembles the latest-and-greatest version of Android. When your app runs on older " +
                        "devices, AppCompat tries to fill in the gaps of UI functionality where it can. While " +
                        "using AppCompat makes your APK a lot larger and makes app development more " +
                        "confusing, many developers are grateful for the backwards-compatibility that it " +
                        "offers."));
        questionsAns.add(new QuestionAnswerModel(128, "What is WorkManager ?",
                "Many times, the work that we need to do on background threads has to be " +
                        "performed in near-real time. But sometimes the work that we need to do can " +
                        "happen totally independently from what the user may (or may not) being doing in " +
                        "our UI. So while a “pull to refresh” UI operation requires us to do a refresh right now," +
                        "a periodic refresh from the server might happen every few hours, even if the user is " +
                        "not in the app right now.\n" +
                        "While there have been many solutions over the years for this problem, Google is " +
                        "steering us towards WorkManager right now. We can teach WorkManager about " +
                        "background work to be performed, then schedule that work to occur. That schedule " +
                        "might be based in part on time (“do it soon”, “do it every few hours”, etc.). That " +
                        "schedule might be based in part on the state of the device (“do it when the device is " +
                        "on a charger”, “do it when the device is on WiFi”, etc.). Then, WorkManager will " +
                        "arrange to do the work, even if the user leaves our UI."));
        questionsAns.add(new QuestionAnswerModel(129, "What is AndroidKTX ?",
                "AndroidKTX is collection of new features in Kotlin such as extension function, designed to make android SDK a bit easier to use with both language support."));
        questionsAns.add(new QuestionAnswerModel(130, "What is R file ?",
                ""));
//        questionsAns.add(new QuestionAnswerModel(131,"",""));
//        questionsAns.add(new QuestionAnswerModel(132,"",""));
//        questionsAns.add(new QuestionAnswerModel(133,"",""));
//        questionsAns.add(new QuestionAnswerModel(134,"",""));
//        questionsAns.add(new QuestionAnswerModel(135,"",""));
//        questionsAns.add(new QuestionAnswerModel(136,"",""));
//        questionsAns.add(new QuestionAnswerModel(137,"",""));
//        questionsAns.add(new QuestionAnswerModel(138,"",""));
//        questionsAns.add(new QuestionAnswerModel(139,"",""));
//        questionsAns.add(new QuestionAnswerModel(140,"",""));
//        questionsAns.add(new QuestionAnswerModel(141,"",""));
//        questionsAns.add(new QuestionAnswerModel(142,"",""));
    }
}
