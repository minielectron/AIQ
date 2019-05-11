package com.androidcodeshop.aiq;

import com.androidcodeshop.aiq.ui.main.QuestionAnswerModel;

import java.util.ArrayList;

public class Questions {
    private ArrayList<QuestionAnswerModel> questionsAns;

    public Questions() {
        this.questionsAns = new ArrayList<>();
        populateQuestions();
    }

    public ArrayList<QuestionAnswerModel> getQuestionsAns() {
        return questionsAns;
    }

    public int getNumberOfQuestion() {
        return questionsAns.size();
    }

    private void populateQuestions() {
        questionsAns.add(new QuestionAnswerModel("What is Android ? ", "Android is a mobile operating system developed by Google. It is based on a modified version of the Linux kernel and other open source software, and is designed primarily for touchscreen mobile devices such as smartphones and tablets. In addition, Google has further developed Android TV for televisions, Android Auto for cars, and Wear OS for wrist watches, each with a specialized user interface. Variants of Android are also used on game consoles, digital cameras, PCs and other electronics.\n" +
                "\n" +
                "Initially developed by Android Inc., which Google bought in 2005, Android was unveiled in 2007, with the first commercial Android device launched in September 2008. The operating system has since gone through multiple major releases, with the current version being 9 \"Pie\", released in August 2018. Google released the first Android Q beta on all Pixel phones on March 13, 2019. The core Android source code is known as Android Open Source Project (AOSP), and is primarily licensed under the Apache License."));
        questionsAns.add(new QuestionAnswerModel("What is an Application?", "" +
                "An application is something " +
                "that a user might install from the Play Store or otherwise download to their device. " +
                "That application should have some user interface, and it might have other code " +
                "designed to work in the background (multi-tasking). for example- This application has some UI which provides the important questions and answers."));
        questionsAns.add(new QuestionAnswerModel("Which are the programming languages in which we can write the mobile applications?", "" +
                "There are many languages in which we can write the mobile application but Java is the most extensively used and now Kotlin is recommended by google." +
                "Other languages are : \n" +
                "C/C++ for performance gain\n" +
                "C/C++ with OpenGL for 3D applications and Camera Applications\n" +
                "You can also use HTML, CSS and JavaScript for writing web modules in android"));
        questionsAns.add(new QuestionAnswerModel("What are the different components in Android?", "" +
                "There are main four components in Android :\n" +
                "   1.Activities : Building blocks of User Interface(UI)\n" +
                "   2.Broadcast Receiver : Helps in receiving the broadcast such as Battery low, Network connections, reboot and so many..\n" +
                "   3.Services : Background threads in android, can run independent of activity\n" +
                "   4.Content Provides : Provides the abstraction on data stored in the devices that is accessible by multiple applications such as contacts, files etc."));
        questionsAns.add(new QuestionAnswerModel("What is Widgets or Views ?", "" +
                "A control element (sometimes called a control or widget) in a graphical user interface is an element of interaction, such as a button or a scroll bar.(-wiki) \n\n" +
                "Widgets or Views are the micro units of User Interface Design in Android. " +
                "Example : \n" +
                "Buttons\n" +
                "Fields\n" +
                "Labels\n" +
                "RadioButton, CheckBoxes, etc\n" +
                "These are generally Java classes which extends the View class. such as TextView extends View"));
        questionsAns.add(new QuestionAnswerModel("What is Dalvik and ART and what is difference between them?",
                "In terms of Android, Dalvik and ART are virtual machines (VM)s. Virtual machines\n" +
                        "are used by many programming languages, such as Java, Perl, and Smalltalk. Dalvik\n" +
                        "and ART are designed to work much like a Java VM, but optimized for embedded\n" +
                        "Linux environments.\n" +
                        "Primarily, the difference between the two is that ART is used on Android 5.0 and\n" +
                        "higher, while Dalvik was used on older devices."));
        questionsAns.add(new QuestionAnswerModel("What is Emulator in Android Studio?",
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
        questionsAns.add(new QuestionAnswerModel("What is gradle?",
                "Gradle is software for building software, otherwise known as “build automation " +
                        "software” or “build systems”.A build system does not compile, link, package, etc. applications " +
                        "directly, but instead directs separate compilers, linkers, and packagers to do that " +
                        "work.\n" +
                        "Gradle uses a domain-specific language (DSL) built on top of Groovy to accomplish " +
                        "these tasks."));
        questionsAns.add(new QuestionAnswerModel("What is Groovy?",
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
        questionsAns.add(new QuestionAnswerModel("What Does Android Have To Do with Gradle?",
                "Google has published the Android Gradle Plugin, which gives Gradle the ability to\n" +
                        "build Android projects. Google is also using Gradle and the Android Gradle Plugin\n" +
                        "as the build system behind Android Studio."));
        questionsAns.add(new QuestionAnswerModel("What is gradle wrapper ?",
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
        questionsAns.add(new QuestionAnswerModel("What is project level build.gradle ?",
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

        questionsAns.add(new QuestionAnswerModel("What is module level build.gradle ?",
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

        questionsAns.add(new QuestionAnswerModel("What is Android Manifest file in Android ?",
                "The AndroidManifest.xml is the foundation of android application and it contains all the information about the application " +
                        ", here we declare all the activities, receivers, content providers, services, permissions and so on. \n" +
                        "All the activities that are used in the application is defined inside this with their properties such as which is LAUNCHER activity and which is default. "));

        questionsAns.add(new QuestionAnswerModel("Which tag is used in android manifest to show that we support multiple screens?",
                "<support-screens> tag is used to show that we support different size screens as follows :\n" +
                        "<supports-screens\n" +
                        "android:largeScreens=\"true\"\n" +
                        "android:normalScreens=\"true\"\n" +
                        "android:smallScreens=\"false\"\n" +
                        "android:xlargeScreens=\"true\" />"));
        questionsAns.add(new QuestionAnswerModel("What does android:allowBackup=\"true\" represents?",
                "This attribute indicates that our application " +
                        "should participate in Android’s automatic backup system. By default it can backup upto 25MB data. It's not good idea to use it until you know the technicals consequences."));

        questionsAns.add(new QuestionAnswerModel("What is Lint ?",
                "The Android lint tool is a static code analysis tool that checks your Android project source files for potential bugs and optimization improvements for correctness, security, performance, usability, accessibility, and internationalization."));
        questionsAns.add(new QuestionAnswerModel("What is Resources in Android?",
                "Resources are static bits of information held outside the Java source code. As we " +
                        "discussed previously, resources are stored as files under the res/ directory in your " +
                        "source set (e.g., app/src/main/res/). Here is where you will find all your icons and " +
                        "other images, your externalized strings for internationalization, and more."));
        questionsAns.add(new QuestionAnswerModel("What is Html in string ?", "" +
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
        questionsAns.add(new QuestionAnswerModel("What is Lint ?", ""));
        questionsAns.add(new QuestionAnswerModel("What is Lint ?", ""));
    }
}
