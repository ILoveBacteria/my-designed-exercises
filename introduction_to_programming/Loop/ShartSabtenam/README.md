<div dir="rtl">
+ طراح: محمدمعین عربی
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت

----------
کاربران برای عضویت در یک سایت باید نام کاربری و پسورد خود را وارد کنند. به دلایل فنی، نام کاربری یک کاربر باید **فاقد** کاراکتر‌های خاصی باشد. این کاراکترها عبارتند از:

```
, ; ! % < > ( ) $
```

شما باید برنامه‌ای بنویسید که نام کاربری‌های غیر مجاز را تشخیص دهد تا از ثبت این نام کاربری جلوگیری شود.

# ورودی

ورودی شامل دو خط است. در خط اول ورودی، عدد `n` به معنای تعداد کاراکتر‌های نام کاربری داده می‌شود. در خط دوم ورودی، یک نام کاربری با `n` کاراکتر داده می‌شود.

$$ 1 \le n \le 1000 $$

# خروجی

خروجی تنها یک خط دارد. در صورتی که نام کاربری غیر مجاز بود، در تنها خط خروجی کلمه `INVALID` را چاپ کنید. و در صورتی که نام کاربری مجاز بود، در تنها خط خروجی کلمه `VALID` را چاپ کنید.

# مثال

## ورودی نمونه ۱

```
7
moein81
```

## خروجی نمونه ۱
```
VALID
```

**توضیح:** نام کاربری وارد شده دارای هیچ‌کدام از کاراکتر‌های غیر مجاز بالا نیست.
## ورودی نمونه ۲

```
11
h4ck3R!m4N!
```

## خروجی نمونه ۲

```
INVALID
```

**توضیح:** این نام کاربری دارای کاراکتر `!` است که باعث می‌شود غیر مجاز به حساب بیاید.
</div>