<div dir="rtl">
+ طراح: محمدمعین عربی
+ سطح: آسان
+ مباحث مورد پوشش: Git, OOP

----------
در این تمرین می‌خواهیم روی یک پروژه‌ی اولیه تغییراتی ایجاد کنیم و با استفاده از گیت این تغییرات را ثبت کنیم. اگر تا به حال گیت را نصب نکرده‌اید، می‌توانید از این [لینک](https://git-scm.com/downloads) دانلود کنید.

پروژه‌ی اولیه‌ی را می‌توانید از %problem.initial_project% دانلود کنید.

# جزئیات پروژه

<details class="grey">
<summary>ساختار فایل پروژه</summary>
```
hello-git
	└── src
		└── <mark title="باید پیاده‌سازی شود">Calculator.java</mark>
```

</details>

## کلاس `Calculator`

این کلاس دارای چند متد `static` برای انجام عملیات‌های مختلف ریاضی است. مانند محاسبه‌ی فاکتوریل، ب.م.م، عدد اول و …

در ادامه شما باید تغییرات و پیاده‌سازی‌های خواسته شده را **به ترتیب** انجام دهید و آن‌ها را کامیت کنید.

## ۱. شروع گیت

پس از دانلود پروژه‌ی اولیه، در دایرکتوری اصلی پروژه باید دستور `git init` را اجرا کنید. پس از اجرای این دستور دایرکتوری پروژه به این شکل باید شود:

```
hello-git
	├── <mark>.git/</mark>
	└── src
		└── Calclator.java
```


## ۲. کامیت اول

در کامیت اول شما باید **بدون** تغییر دادن(حتی یک اسپیس!) فایل `Calculator.java` را با پیام `Initial commit` کامیت کنید.

## ۳. کامیت دوم

در این مرحله از شما می‌خواهیم دو متد جدید به این کلاس اضافه کنید:

```java Calculator.java
public static boolean isEven(int number) {
	// TODO: Implement
}

public static boolean isOdd(int number) {
	// TODO: Implement
}
```

این متدها یک عدد ورودی می‌گیرند و مشخص می‌کنند این عدد زوج است یا فرد. سپس تغیییرات ایجاد شده را با پیام `Add isEven and isOdd methods` کامیت کنید.

## ۴. کامیت سوم

در این مرحله شما باید باگی را که در متد `factorail` وجود دارد پیدا و رفع کنید.

```java Calculator.java
public static int factorial(int a) {
	int result = 1;
        for (int i = 2; i <= a; i++) {
	        result += i;
        }
        return result;
}
```


 این متد یک ایراد محاسباتی مقدار فاکتوریل دارد که پس از تغییر آن، تغییرات جدید را با پیام `Fix factorial method` کامیت کنید.

# نکات

1. حتما تغییرات را به ترتیب گفته شده کامیت کنید.
2. پیامی که به هر کامیت اضافه می‌کنید باید دقیقا برابر پیام گفته شده باشد.
3. در آخر با گرفتن دستور `git log` شما باید بتوانید هر سه کامیت خود را مشاهده کنید:

<details class="green">
<summary>مشاهده تاریخچه کامیت‌ها</summary>

```bash Terminal
$ git log
commit 2ec9b03993b019cc1314c5a19d9a7ddfa805c319 (HEAD -> master)
Author: Moein Arabi <--->
Date:   Tue Oct 0 00:00:00 0000

    Fix factorial method

commit ca0f80c9f0d68aaa84e779d1ed5da226236fbf6a
Author: Moein Arabi <--->
Date:   Tue Oct 0 00:00:00 0000

    Add isEven and isOdd methods

commit c2ac4d664e5381ba5db597cd8d453add648fde4b
Author: Moein Arabi <--->
Date:   Tue Oct 0 00:00:00 0000

    Initial commit

```

</details>

# آن‌چه باید آپلود کنید

محتوای داخلی دایرکتوری `.git` را `zip` کنید و ارسال کنید:
```
.git
	└── <zip_file_name.zip>
		└── <mark title="محتوای داخلی .git">---</mark>
```

</div>