<div dir="rtl">
+ طراح: محمدمعین عربی
+ سطح: سخت
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت

----------

پیام‌رسان واتساپ با تمام قابلیت‌های منحصر به فردی که در اختیار کاربران قرار داد بالاخره توانست در سال 2030  از سد پیام‌رسان تلگرام عبور کند و تلگرام ورشکسته شود! حال تلگرام پس از اخراج نیروهای خود می‌خواهد نیروهای تازه نفس استخدام کند تا با نام جدید تلگراف به میدان بازگردد.

شما به عنوان یک برنامه‌نویس تازه نفس در تلگراف استخدام شده‌اید. شما باید بخشی از پروژه‌ی تلگراف را پیاده‌سازی کنید. در هر خط دستوراتی به برنامه داده می‌شود و برنامه پاسخ مناسب را در هر خط خروجی چاپ می‌کند.

# ساختن کاربر جدید

در پیام‌رسان تلگراف هر کاربر یک آیدی منحصر به فرد و یک نام با حداکثر طول 10 کاراکتر دارد که آیدی از نوع integer می‌باشد. طبیعتا در ابتدا لیست گفت‌وگوی کاربر خالی است.

با دستور زیر یک کاربر جدید ساخته می‌شود:
```
new_user [ID] [NAME]
```

+ اگر کاربری از قبل با آیدی یکسان ساخته شده باشد، پیغام خطای `User already exist` چاپ می‌شود.
+ اگر ساخت کاربر جدید موفقیت آمیز بود، پیغام `User created successfully` در خروجی چاپ می‌شود.

\**تضمین می‌شود:** نام کاربر بدون هیچ فاصله‌ای باشد.

# ایجاد گفت‌وگوی جدید

در پیام‌رسان تلگراف هر گفت‌وگو تنها بین دو نفر انجام می‌شود و شامل پیام‌های رد و بدل شده بین این دو است. طبیعتا در ابتدای ساخت یک گفت‌وگو هیچ پیامی وجود ندارد.

با دستور زیر یک گفت‌وگوی جدید بین دو کاربر ساخته می‌شود:
```
new_chat [ID_1] [ID_2]
```

+ اگر هر یک از آیدی‌ها موجود نباشد، پیغام `User not found` چاپ می‌شود.
+ اگر از قبل یک گفت‌وگو بین دو کاربر موجود باشد، پیغام `Chat already exist` چاپ می‌شود.
+ در غیر این صورت پیغام موفقیت آمیز `Chat created successfully` چاپ می‌شود.

\**تضمین می‌شود:** آیدی‌ها با هم برابر نباشند.

# ارسال پیام

هر پیام یک فرستنده و یک متن با حداکثر طول 100 کاراکتر دارد.

با دستور زیر یک پیام بین دو کاربر ارسال می‌شود:
```
message <mark title="آیدی فرستنده">[ID_1]</mark> <mark title="آیدی گیرنده">[ID_2]</mark> [TEXT]
```

+ اگر هر یک از آیدی‌ها موجود نباشد، پیغام `User not found` چاپ می‌شود.
+ اگر گفت‌وگویی بین دو کاربر موجود نباشد، پیغام `Chat not found` چاپ می‌شود.
+ در غیر این صورت پیغام `Message sent` چاپ می‌شود. 

# خواندن پیام

با دستور زیر تمام پیام‌های رد و بدل شده در یک گفت‌وگو بین دو کاربر، در خط‌های جداگانه به ترتیب قدیمی تا جدید نشان داده می‌شود:

### قالب ورودی
```
read_messages [ID_1] [ID_2]
```

### قالب خروجی

```
<mark title="نام فرستنده">[FROM]</mark>:<mark title="متن پیام">[TEXT]</mark>
```

+ اگر پیام یا گفت‌وگویی بین دو کاربر وجود نداشته باشد، پیغام `Empty` چاپ می‌شود. 
+ اگر هر یک از آیدی‌ها وجود نداشته باشد پیغام `User not found` چاپ می‌شود.
+ اگر گفت‌وگویی بین دو کاربر موجود نباشد، پیغام `Chat not found` چاپ می‌شود.

# خاموش کردن سرور

با دستور زیر برنامه خاتمه می‌یابد:

```
shutdown
```


# ورودی

هر خط ورودی شامل یک دستور است و تعداد دستورهای ورودی تا زمانی که برنامه دستور shutdown را دریافت نکرده است، ادامه می‌یابد.

\**تضمین می‌شود:** تعداد پیام‌های موجود در یک گفت‌وگو حداکثر $100$ باشد. همچنین تعداد گفت‌وگوهای هر کاربر حداکثر $100$ باشد.

# خروجی

خروجی شامل پاسخ دستورات اجرا شده است که به کاربر نمایش داده می‌شود.

# مثال

## ورودی نمونه ۱
```
1 2
```


## خروجی نمونه ۱
```
1.000000
2.000000
```

<details class="blue">
<summary>راهنمایی</summary>
شما می‌توانید برای پیاده‌سازی این سوال **ساختار**های زیر را در نظر بگیرید:

+ ساختار کاربر
+ ساختار گفت‌وگو
+ ساختار پیام
+ ...

درباره‌ی **ساختارهای تو-در-تو(Nested Structure)** و نحوه‌ی استفاده از آن می‌توانید از این [لینک](https://www.geeksforgeeks.org/nested-structure-in-c-with-examples/) بخوانید.
</details>
</div>