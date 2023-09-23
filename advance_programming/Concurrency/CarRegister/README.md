<div dir="rtl">
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت
+ طراح: محمدمعین عربی
+ مباحث مورد پوشش: Concurrency, Future

----------

اخیرا معین قصد خرید خودرو دارد ولی از آنجایی که تعداد خودروها محدود است باید سریع ثبت‌نام را انجام دهد. شما باید به کمک او بشتابید و در این تمرین برنامه‌ای پیاده‌سازی کنید که کار ثبت‌نام را به صورت هم‌روند انجام دهد.

پروژه‌ی اولیه‌ی را می‌توانید از %problem.initial_project% دانلود کنید.

# جزئیات پروژه

## داده شمارشی `Status`

```java Status.java
public enum Status {
    OK, FAIL, TIMEOUT
}
```

از این داده شمارشی برای مشخص کردن نتیجه پاسخ سرور استفاده می‌شود.

## کلاس `CarRequest`

```java CarRequest.java
import java.util.concurrent.Callable;

public class CarRequest implements Callable<Status> {
    private final String carName;
    
    @Override
    public Status call() throws Exception {
        // TODO: implement
        return null;
    }
}
```

این کلاس اینترفیس `Callable` را پیاده‌سازی می‌کند و وظیفه ارسال درخواست ثبت‌نام یک خودرو به سرور و دریافت پاسخ آن را به عهده دارد. شما می‌توانید به دلخواه متد سازنده و فیلدهای مورد نیازتان را به این کلاس اضافه کنید.

#### متد `call`

در این متد یک سوکت به سرور که روی پورت `5000` قرار دارد باز می‌شود. کلاینت نام خودرو را به صورت یک `String` برای ثبت‌نام به سرور ارسال می‌کند و منتظر دریافت پاسخ سرور می‌ماند. پاسخ سرور در صورت تایید یا رد ثبت‌نام، یک رشته به صورت `OK` یا `FAIL` است.

در نهایت خروجی این متد یک enum از نوع `Status` معادل با رشته دریافتی است.

## کلاس `CarRegister`

```java CarRegister.java
import java.util.List;
import java.util.Map;

public class CarRegister {
    private final List<String> cars;

    public CarRegister(List<String> cars) {
        this.cars = cars;
    }

    public void startRegistering() {
        // TODO: implement | non-blocking method
    }

    public Map<Status, Integer> getFinalResult() {
        // TODO: implement | blocking method
        return null;
    }

    public int progress() {
        // TODO: implement
        return 0;
    }
}
```


#### سازنده کلاس

متد سازنده‌ی کلاس تنها یک پارامتر به عنوان ورودی می‌گیرد. پارامتر لیستی از `String` شامل نام خودروهایی است که قرار است درخواست ثبت‌نام آن‌ها به سمت سرور ارسال شود.

#### متد `startRegistering`

با فراخوانی این متد ارسال هم‌روند درخواست‌های ثبت‌نام به سمت سرور آغاز می‌شود. ارسال هر نام خودرو به کمک کلاس `CarRequest` انجام می‌شود. در یک لحظه نباید بیشتر از 3 درخواست هم‌روند در حال اجرا وجود داشته باشد. 

**مجموع** تمامی درخواست‌ها حداکثر باید 5 ثانیه طول بکشد. در صورت پایان یافتن مهلت زمانی، هر درخواست در حال اجرا یا منتظر اجرا باید متوقف شود و نوع `Status.TIMEOUT` برای آن‌ها تعیین شود. برای پیاده‌سازی می‌توانید از متد `invokeAll` در کلاس `ExecutorService` استفاده کنید. برای مطالعه می‌توانید به [اینجا](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorService.html) و [آنجا](https://howtodoinjava.com/java/multi-threading/executorservice-invokeall/) مراجعه کنید.

*این متد باید به صورت non-blocking پیاده‌سازی شود. یعنی با اجرا شدن این متد در ترد اصلی نباید آن را متوقف کند.*

#### متد `progress`

خروجی این متد یک عدد از نوع `int` است. این خروجی نشان‌دهنده‌ی میزان پیشرفت تعداد درخواست‌های اجرا شده (درخواست‌های در حال اجرا و اجرا شده) بر حسب درصد را دارد.

#### متد `getFinalResult`

با فراخوانی این متد، نتایج اجرای همه‌ی درخواست‌ها به صورت یک Map برگردانده می‌شود. کلید این مپ از جنس `Status` و مقدار متناظر آن از جنس `Integer` است که این مقدار `Integer` تعداد اتفاق نوع پاسخ از سرور است.  

*این متد باید به صورت blocking باشد یعنی ترد اصلی با فراخوانی این متد تا زمان پایان یافتن درخواست‌ها باید متوقف شود.*

<details class="grey">
<summary>یک نمونه خروجی</summary>

```
{
    Status.OK: 5,
    Status.FAIL: 1,
    Status.TIMEOUT: 0
}
```

در اینجا 6 درخواست به سرور ارسال شده بود که 5تای آن‌ها `OK` بودند، یکی از آن‌ها `FAIL` شده بود و درخواستی `TIMEOUT` نشده بود.

</details>
# آنچه شما باید پیاده‌سازی کنید

1. متدهای کلاس `CarRegister` را مطابق خواسته‌ی مسئله پیاده‌سازی کنید.
2. متد `call` کلاس `CarRequest` را برای ارسال درخواست به سرور و برگرداندن پاسخ آن تکمیل کنید.

# نکات

+ به بستن سوکت‌ها دقت کنید.
+ در صورت نیاز خروجی سوکت را فلاش کنید.

# آن‌چه باید آپلود کنید

ساختار فایل `zip` ارسالی باید به صورت زیر باشد:
```
<zip_file_name.zip>
	├── CarRegister.java
	└── CarRequest.java
```

</div>