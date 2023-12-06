<div dir="rtl">
+ طراح: محمدمعین عربی
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت

----------
برنامه‌ای بنویسید که با دریافت دو عدد $a$ و $b$ حاصل جمع این دو عدد را وقتی که ابتدا صفرها را حذف کنیم و بعد جمع کنیم با وقتی که اول جمع کنیم و بعد صفرها را حذف کنیم، مقایسه کند.

# ورودی

ورودی شامل دو خط است. در هر خط عدد $a$ و $b$ ورودی داده می‌شود.

$$ 1 \le a,b \le 100000 $$

# خروجی

خروجی شامل دو خط است. در خط اول خروجی حاصل جمع دو عدد پس از حذف صفر نوشته می شود. در خط دوم خروجی در صورتی که حاصل اگر ابتدا صفرها را حذف کنیم و بعد جمع کنیم با وقتی که اول جمع کنیم و بعد صفرها را حذف کنیم برابر باشد، عبارت `YES` و در غیر صورت عبارت `NO` چاپ شود.

# مثال

## ورودی نمونه ۱

```
601
100
```


## خروجی نمونه ۱

```
71
NO
```

<details class="blue">
<summary>توضیحات مثال ۱</summary>
$$ 601+100=701 $$
$$ 61+1=62 $$

همینطور که می‌بینید این دو حاصل با هم برابر نیستند و حاصل جمع اول بدون صفر برابر با 71 خواهد شد اما حاصل جمع دوم بدون صفر برابر با 62 شده است.
</details>


## ورودی نمونه ۲

```
101
102
```

## خروجی نمونه ۲

```
23
YES
```

<details class="blue">
<summary>توضیحات مثال ۲</summary>
$$ 101+102=203 $$
$$ 11+12=23 $$

می‌بینیم که 203 بدون صفر همان 23 می‌شود.
</details>
</div>