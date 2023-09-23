<div dir="rtl">
+ محدودیت زمان: ۱ ثانیه
+ محدودیت حافظه: ۲۵۶ مگابایت
+ طراح: محمدمعین عربی
+ مباحث مورد پوشش: Concurrency

---

شما در این تمرین باید یک رستوران را شبیه‌سازی کنید. این رستوران شامل بخش‌های سرور و آشپزخانه است که در دو نخ جداگانه اجرا می‌شوند. وظیفه‌ی سرور این است که مشتریان(کلاینت) به آن متصل شوند و سفارش غذا بدهند. سپس سرور سفارشات را به لیست سفارشات اضافه کند تا غذا‌ها توسط آشپزخانه آماده شوند.

پروژه‌ی اولیه‌ی را می‌توانید از %problem.initial_project% دانلود کنید.

## جزئیات پروژه

<details class="blue">
<summary>کلاس `Server`</summary>

```java Server.java
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private final Resource resource;
    
    public Server(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        // TODO: Implement
    }
}
```

در این کلاس سرور رستوران اجرا می‌شود. سرور روی پورت `5000` منتظر وصل شدن کلاینت‌ها است. زمانی که یک کلاینت به سرور متصل شد، یک شی از کلاس `Order` به سمت سرور ارسال می‌کند. سرور وظیفه دارد این شی را دریافت کند و آن را به کمک متد `addNewOrder` در کلاس `Resource`، به لیست سفارشات اضافه کند.

تا زمانی که سفارش مشتری آماده نشده است، سوکت بین سرور و کلاینت باز می‌ماند. زمانی که غذا آماده شود، پیغام `<mark class="orange" title="آیدی سفارش"><order_id></mark> is ready` برای کلاینت ارسال می‌شود و سوکت بسته می‌شود.

توجه کنید درخواست‌های کلاینت‌ها باید به صورت هم‌روند انجام شوند. یعنی کلاینت دیگر نباید منتظر پایان یافتن سفارش کلاینت قبلی شود تا به سرور وصل شود.

</details>

<details class="teal">
<summary>کلاس `Kitchen`</summary>

```java Kitchen.java
public class Kitchen implements Runnable {
    private final Resource resource;
    
    public Kitchen(Resource resource) {
        this.resource = resource;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                Order order = resource.getNextOrder();
                order.cookFood();
                foodIsReady(order);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void foodIsReady(Order order) {
        // TODO: Implement
    }
}
```


این کلاس آشپزخانه‌ی رستوران است. سفارش مشتریان را دریافت می‌کند و غذای آن‌ها را آماده می‌کند.

#### متد `run`

در این متد یک حلقه‌ی بی‌نهایت وجود دارد که هر بار آخرین سفارش ثبت شده را دریافت می‌کند و متد `cookFood`  را روی آن اجرا می‌کند. در انتها توسط متد `foodIsReady` اطلاع می‌دهد که غذا آماده شده است.

#### متد `foodIsReady`

این متد یک شی از جنس `Order` دریافت می‌کند و به کمک آن به نخ اجرایی کلاینت مورد نظر در سرور اطلاع می‌دهد تا پیغام `<mark class="orange" title="آیدی سفارش"><order_id></mark> is ready` برای کلاینت ارسال شود. در انتها سوکت بین سرور و کلاینت بسته می‌شود.


</details>

<details class="yellow">
<summary>کلاس `Resource`</summary>

```java Resource.java
import java.util.ArrayList;
import java.util.List;

public class Resource {
    private final List<Order> orders = new ArrayList<>();
    
    public void addNewOrder(Order order) {
        // TODO: Implement
    }
    
    public Order getNextOrder() throws InterruptedException {
        // TODO: Implement
    }
    
    public List<Order> getOrders() {
        return orders;
    }
}
```

این کلاس دارای ویژگی `orders` است که لیست سفارشات تولید شده توسط سرور را نگهداری می‌کند و آشپزخانه آن‌ها را پردازش می‌کند. این شی بین چند نخ مشترک است.

#### متد `addNewOrder`

این متد یک شی از نوع `Order` ورودی می‌گیرد و آن را به لیست سفارشات اضافه می‌کند. در همین متد باید از race-conditionهای احتمالی جلوگیری شود.

این متد توسط کلاس `Server` برای اضافه کردن یک شی سفارش جدید فراخوانی می‌شود.

#### متد `getNextOrder`

این متد آخرین سفارش را از لیست سفارشات حذف می‌کند و آن را بر می‌گرداند. در همین متد باید از race-conditionهای احتمالی جلوگیری شود.

این متد توسط کلاس `Kitchen` برای دریافت یک سفارش فراخوانی می‌شود.

</details>

<details class="grey">
<summary>کلاس `Order`</summary>

```java Order.java
import java.io.Serializable;

public class Order implements Serializable {
    private final int id;
    private final int cookTime;
    
    public Order(int id, int cookTime) {
        this.id = id;
        this.cookTime = cookTime;
    }
    
    public void cookFood() throws InterruptedException {
        Thread.sleep(cookTime);
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }
}
```

*این کلاس از قبل پیاده‌سازی شده است*

این کلاس، واسط `Serializable` را پیاده‌سازی می‌کند. اشیای ساخته شده از این کلاس در زمان وصل شدن کلاینت به سرور ارسال می‌شود.

ویژگی `id` آیدی سفارش است که در بین تمامی سفارشات منحصر به فرد است.

ویژگی `cookTime` مدت زمانی است که آشپزخانه طول می‌کشد تا غذا را آماده کند.


</details>

## آنچه شما باید پیاده‌سازی کنید

1. سرور رستوران را پیاده‌سازی کنید به طوری که درخواست کلاینت‌ها را هم‌روند پردازش کند
2. دو متد ذکر شده در کلاس `Resource` را پیاده‌سازی کنید
3. متد `foodIsReady` در کلاس `Kitchen` را پیاده‌سازی کنید

## نکات

+ سوکت تنها باید بعد از آماده شدن غذای مشتری بسته شود
+ نیازی به ایجاد تغییرات در متد `run` کلاس `Kitchen` نیست
+ فقط در متد‌های کلاس `Resource` باید از race-condition جلوگیری کنید
+ ایجاد تغییرات در کلاس `Order` برای داوری نادیده گرفته می‌شود

## آنچه باید آپلود کنید

ساختار فایل `zip` ارسالی باید به صورت زیر باشد:
```
<zip_file_name.zip>
	├── Server.java
	├── Kitchen.java
	└── Resource.java
```

</div>