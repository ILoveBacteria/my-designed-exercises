<div dir="rtl">
+ طراح: محمدمعین عربی
+ سطح: متوسط
+ مباحث مورد پوشش: OOP

----------

در این تمرین می‌خواهیم یک سرویس مشابه یوتیوب پیاده‌سازی کنیم که کاربران امکان آپلود ویدیو، مشاهده ویدیو و گذاشتن کامنت زیر ویدیو را دارند.

پروژه‌ی اولیه‌ی را می‌توانید از %problem.initial_project% دانلود کنید.

# جزییات پروژه

<details class="grey">
<summary>ساختار فایل پروژه</summary>
```
youtube
	├── <mark title="باید پیاده‌سازی شود">Comment.java</mark>
	├── <mark title="باید پیاده‌سازی شود">User.java</mark>
	└── <mark title="باید پیاده‌سازی شود">Video.java</mark>
```

</details>

## کلاس `Commnet`

اشیای ساخته شده از این کلاس بیانگر یک کامنت ایجاد شده توسط یک کاربر زیر یک ویدیو است.

#### پراپرتی‌ها

1. `text`: این پراپرتی متن کامنت را نگهداری می‌کند و از نوع `String` است.
2. `author`: این پراپرتی شی کاربری که این کامنت را نوشته نگهداری می‌کند و از نوع `User` است.
3. `video`: این پراپرتی شی ویدیویی است که کامنت زیر آن گذاشته شده است و از نوع `Video` است.
4. `createdAt`: تاریخ و زمانی که کامنت ایجاد شده است و از نوع `LocalDateTime` است. این پراپرتی در زمان ساخت شی به زمان همان لحظه باید مقداردهی شود.

تمامی پراپرتی‌های این کلاس باید سطح دسترسی `private` داشته باشند.

#### متدها

1. متد سازنده: این کلاس تنها یک متد سازنده دارد و به ترتیب مقادیر `text` و `author` و `video` را ورودی می‌گیرد و آن‌ها را مقداردهی می‌کند.
2. متدهای *getter*: برای تمامی پراپرتی‌های ذکر شده باید این متد را پیاده‌سازی کنید.

## کلاس `User`

اشیای این کلاس بیانگر یک کاربر در سیستم است.

#### پراپرتی‌ها

1. `name`: این پراپرتی نام کاربر را نگهداری می‌کند و از نوع `String` است.
2. `username`: این پراپرتی نام کاربری را نگهداری می‌کند و از نوع `String` است.
3. `birthdate`: این پراپرتی تاریخ تولد کاربر را نگهداری می‌کند و از نوع `LocalDate` است.
4. `videos`: این پراپرتی لیستی از اشیای ویدیویی است که کاربر آن‌ها را در سایت آپلود کرده است و از نوع `List` است.

تمامی پراپرتی‌های این کلاس باید سطح دسترسی `private` داشته باشند.

#### متدها

1. متد سازنده: این کلاس تنها یک متد سازنده دارد و سه پارامتر را ورودی می‌گیرد. به ترتیب `name` و `username` و `birthdate` هر سه از نوع `String` را ورودی می‌گیرد. 

    توجه کنید که `birthdate` به صورت یک **رشته** ورودی داده می‌شود و برای مقداردهی پراپرتی آن ابتدا باید آن را به شئی از `LocalDate` تبدیل کنید.

2. متدهای *getter*: برای تمامی پراپرتی‌های ذکر شده باید این متد را پیاده‌سازی کنید.
3. متدهای *setter*: تنها برای پراپرتی `name` این متد را پیاده‌سازی کنید.
4. متد `age`: این متد سن کاربر را با توجه به تاریخ تولد آن محاسبه می‌کند و یک عدد از نوع `int` خروجی می‌دهد.
5. متد `comment`: با فراخوانی این متد، کاربر یک کامنت به یک ویدیو اضافه می‌کند و مقدار بازگشتی `void` را دارد.
    
    دو پارامتر به ترتیب شئی از نوع `Video` و متن کامنت از نوع `String` را ورودی می‌گیرد و به کمک متد `submitComment` یک کامنت به ویدیو اضافه می‌کند.
    
6. متد `watchVideo`: این متد یک پارامتر از نوع `Video` ورودی می‌گیرد و به تعداد بازدیدهای این ویدیو(به شرط نقض نشدن محدودیت) یکی اضافه می‌کند و `true` بر می‌گرداند.

    **محدودیت:** اگر سن کاربر از محدودیت سنی ویدیو کمتر باشد و آپلودکننده‌ی ویدیو نباشد افزایش بازدید صورت نمی‌گیرد و `false` برگردانده می‌شود.

## کلاس `Video`

اشیای این کلاس بیانگر یک ویدیوی آپلود شده در سایت توسط یک کاربر است.

#### پراپرتی‌ها

1. `title`: این پراپرتی نام ویدیو را نگهداری می‌کند و از نوع `String` است.
2. `uploader`: این پراپرتی شی کاربری که آپلود کننده‌ی این ویدیو است را نگهداری می‌کند و از نوع `User` است.
3. `views`: این پراپرتی تعداد بازدید ویدیو را نگهداری می‌کند و از نوع `int` است. در ابتدا مقدار آن `0` است.
4. `ageRestriction`: این پراپرتی حداقل سن مورد نیاز کاربر برای دیدن این ویدیو را نشان می‌دهد و از نوع `int` است.
5. `comments`: این پراپرتی لیستی از اشیای کلاس `Comment` که کاربران زیر ویدیو کامنت ایجاد کرده‌اند را نگهداری می کند و از نوع `List` است.

پراپرتی `views` سطح دسترسی `public` و بقیه‌ی پراپرتی‌ها باید سطح دسترسی `private` داشته باشند.

#### متدها

1. متد سازنده: این کلاس تنها یک متد سازنده دارد و به ترتیب مقادیر `title` و `uploader` و `ageRestriction`را ورودی می‌گیرد و آنها را مقداردهی می‌کند.
2. متدهای *getter*: برای تمامی پراپرتی های ذکر شده به جز `views` باید این متد را پیاده سازی کنید.
3. متدهای *setter*: تنها برای پراپرتی `title` این متد را پیاده‌سازی کنید.
4. متد `submitComment`: این متد یک شی از نوع `Comment` را ورودی می‌گیرد و به لیست `comments` اضافه می‌کند.

# نکات

1. شما اجازه‌ی اضافه کردن پراپرتی دیگری غیر از پراپرتی‌های خواسته‌ی سوال ندارید.

<details class="orange">
<summary>نحوه نامگذاری متدهای *getter* و *setter*</summary>
نامگذاری باید به شکل [Camel case](https://en.wikipedia.org/wiki/Camel_case) باشد. به طور مثال برای نامگذاری متد *setter* و *getter* فیلدی به نام `name` به ترتیب باید به صورت `setName` و `getName` نامگذاری شود. 
</details> 

<details class="teal">
<summary>نحوه استفاده از کلاس `LocalDate` و `LocalDateTime`</summary>
برای مطالعه متدها و نحوه‌ی استفاده از این دو کلاس می‌توانید به [اینجا](https://www.baeldung.com/java-creating-localdate-with-values) و [آنجا](https://howtodoinjava.com/java/date-time/java-localdatetime-class/) مراجعه کنید.
</details> 

# آن‌چه باید آپلود کنید

ساختار فایل `zip` ارسالی باید به صورت زیر باشد:
```
<zip_file_name.zip>
	├── Comment.java
	├── User.java
	└── Video.java
```

</div>