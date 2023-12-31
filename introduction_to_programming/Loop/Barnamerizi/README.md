<div dir="rtl">
+ طراح: محمدمعین عربی
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت

----------
از آن جایی که معین از تلاطم روزگار به ستوه آمده و هیچ یک از کارهایش به ددلاین نمی‌رسد، از شما می‌خواهد برنامه‌ای بنویسید که در هر زمانی به او اعلام کند چه کاری را انجام دهد تا کارها روی یک برنامه‌ریزی درست جلو بروند.

در ابتدا برنامه شما از ورودی، سه بازه‌ی زمانی به همراه کار متناظری که باید در آن بازه صورت بگیرد به صورت یک تک کاراکتر ورودی می‌گیرد. سپس با هر بار وارد شدن یک ساعت در ورودی، کاری را که باید در آن لحظه انجام دهد خروجی می‌دهد. این ورودی گرفتن تا زمانی باید انجام شود که ساعتی بین بازه‌ی `00:00` تا `06:00` ورودی داده نشده باشد.

پیام چاپ شده بر حسب کاراکتر ورودی و بازه به شرح زیر است:

- به ازای کاراکتر `C` پیام `boro c bekhoon!` را چاپ کنید.
- به ازای کاراکتر `R` پیام `boro riz bekhoon!` را چاپ کنید.
- به ازای کاراکتر `S` پیام `boro system amel bekhoon!` را چاپ کنید.
- اگر در هیچ یک از بازه‌ها نبود پیام `khob hame chi khube!` را چاپ کنید.
- قبل از پایان برنامه پیام `boro bekhab!` را چاپ کنید.

# ورودی

ورودی شامل سه خط است که در هر خط آن دو ساعت با الگوی `hh:mm` و یک کاراکتر که بیانگر کار مورد نظر در آن بازه است، با یک فاصله، ورودی داده می‌شود. سپس در خط‌های جداگانه یک ساعت با الگوی `hh:mm` ورودی داده می‌شود.

تضمین می‌شود کاراکتر ورودی یکی از `C` یا `R` یا `S` باشد و هیچ یک از سه بازه همپوشانی نداشته باشند.

$$ 0 \le hh \le 23 $$
$$ 0 \le mm \le 59 $$
# خروجی

در هر خط خروجی پیام متناظر با زمان مورد نظر چاپ می‌شود.

# مثال

## ورودی نمونه ۱
```
07:00 09:00 C
10:00 10:30 R
12:00 18:00 R
07:15
13:00
01:00
```


## خروجی نمونه ۱
```
boro c bekhoon!
boro riz bekhoon!
boro bekhab!
```


## ورودی نمونه ۲
```
12:00 12:30 S
12:31 13:00 R
15:00 18:00 C
12:30
03:00
```


## خروجی نمونه ۲
```
boro system amel bekhoon!
boro bekhab!
```

</div>