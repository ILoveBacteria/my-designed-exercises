<div dir="rtl">
+ طراح: محمدمعین عربی
+ سطح: متوسط
+ مباحث مورد پوشش: Stream

----------

در این تمرین در اختیار شما یک فایل [CSV](https://en.wikipedia.org/wiki/Comma-separated_values) که شامل اطلاعات برخی بازی‌ها است قرار می‌گیرد. شما باید با استفاده از امکانات Stream این فایل را بخوانید و داده‌های موجود آن را استخراج کنید تا در متدهایی که در پیش رو پیاده‌سازی می‌کنید، از آن استفاده کنید.

پروژه‌ی اولیه‌ی را می‌توانید از %problem.initial_project% دانلود کنید.

# جزئیات پروژه

<details class="blue">
<summary>ساختار فایل پروژه</summary>
```
game-analyzer
	├── games.csv
	├── Game.java
	└── <mark title="باید پیاده‌سازی شود">GameAnalyzer.java</mark>
```

</details>

## فایل `games.csv`

یک فایل CSV شامل اطلاعات آماری چندین بازی مختلف است که ستون‌ها و نمونه مقادیری از آن در پایین آمده است:

```csv games.csv
Title,Release Date,Rating,Genres,Plays
Among Us,15-Jun-18,3.0,Indie-Strategy,25000
Minecraft,18-Nov-11,4.3,Adventure-Simulator,33000
```

1. نام بازی
2. تاریخ انتشار بازی به فرمت `DD-MM-YY`
3. امتیاز بازی یک عدد از 0 تا 5
4. ژانر‌های بازی که با کاراکتر `-` از یکدیگر جدا شده‌اند
5. تعداد کاربرانی که این بازی را بازی کردند

## کلاس `GameAnalyzer`

### متد سازنده

```java
private GameAnalyzer(List<Game> games) {
    this.games = games;
}
```


متد سازنده‌ی این کلاس سطح دسترسی private دارد. امکان ساختن یک شی جدید توسط متد پایین میسر می‌شود.

### متد استاتیک `readFromCSV`

```java
public static GameAnalyzer readFromCSV(String fileName) throws IOException {
    // TODO: Implement
    return null;
}
```


این متد تنها یک ورودی از نوع `String` که نام فایل CSV است ورودی می‌گیرد و یک شی از نوع `GameAnalyzer` بر می‌گرداند.

در این متد باید فایل CSV داده شده خوانده شود. هر خط این فایل که شامل داده‌های آماری یک بازی است استخراج شود و به یک شی از نوع `Game` تبدیل شود. در نهایت لیستی از اشیای `Game` توسط متد سازنده ورودی گرفته می‌شود و پراپرتی `games` را مقداردهی می‌کند.

مقادیر موجود در فایل ممکن است شامل اطلاعات تکراری باشد. شما باید روی اشیای بازی، یکتاسازی انجام دهید و موارد تکراری را حذف کنید.

### متد `sortByRating`

```java
public List<Game> sortByRating() {
    // TODO: Implement
    return null;
}
```


این متد بازی‌ها را بر اساس امتیازشان به صورت نزولی مرتب می‌کند و به صورت لیستی از بازی‌ها بر می‌گرداند.

### متد `topMostPlayedGames`

```java
public List<Game> topMostPlayedGames(int n) {
    // TODO: Implement
    return null;
}
```


این متد با ورودی گرفتن عدد `n`، `n` بازی اول با بیشترین تعداد بار پلی شدن را به صورت لیستی از بازی‌ها بر می‌گردند.

### متد `deleteGames`

```java
public void deleteGames(Predicate<Game> filter) {
    // TODO: Implement
}
```


این متد یک `Predicate` ورودی می‌گیرد و بازی‌ها را بر اساس آن فیلتر می‌کند. سپس بازی‌های باقی‌مانده را از لیست حذف می‌کند.

### متد `countReleasedGames`

```java
public int countReleasedGames(int year) {
    // TODO: Implement
    return 0;
}
```


این متد یک عدد از نوع `int` که بیانگر سال است ورودی می‌گیرد و تعداد کل بازی‌های منتشر شده در آن سال را بر می‌گرداند.

### متد `interestGenreInYear`

```java
public Optional<Integer> interestGenreInYear(int year, String genre) {
    // TODO: Implement
    return Optional.empty();
}
```


این متد دو پارامتر ورودی می‌گیرد. یک پارامتر نام ژانر از نوع `String` و یک پارامتر سال از نوع `int`. این متد *میزان علاقه* به یک ژانر در یک سال خاص را به صورت شئی از نوع `Optional` بر می‌گرداند.

میزان علاقه به یک ژانر برابر مجموع تعداد کاربرانی است که بازی‌های آن ژانر را بازی کردند.

### متد `interestGenreChangeWithinYears`

```java
public Map<Integer, Integer> interestGenreChangeWithinYears(int fromYear, int toYear, String genre) {
    // TODO: Implement
    return null;
}
```


این متد ۳ پارامتر ورودی می‌گیرد. دو پارامتر اول بیانگر یک بازه زمانی و پارامتر سوم نام ژانر از نوع `String` است. این متد میزان علاقه به یک ژانر را در هر سال آن بازه محاسبه می‌کند و به صورت یک مپ که کلید آن سال و مقدار متناظر آن میزان علاقه است بر می‌گرداند.

## کلاس `Game`

*این کلاس از قبل پیاده‌سازی شده است.* این کلاس اطلاعات یک بازی متناظر با یکی از ردیف‌های فایل را نگهداری می‌کند.

### پراپرتی‌های کلاس

```java
private final String <mark class="grey" title="نام بازی">title</mark>;
private final int <mark class="grey" title="سال انتشار بازی">year</mark>;
private final double <mark class="grey" title="امتیاز بازی">rating</mark>;
private final List<String> <mark class="grey" title="ژانرهای بازی">genres</mark>;
private final int <mark class="grey" title="تعداد بار بازی شدن">plays</mark>;
```


# آنچه شما باید پیاده‌سازی کنید

1.  متدهای کلاس `GameAnalyzer` را مطابق خواسته‌ی مسئله پیاده‌سازی کنید.

# نکات

+ استفاده از حلقه **ممنوع** است.
+ پس از اتمام کار با فایل در متد `readFromCSV` آن را ببندید.
+ متدهایی که یک پارامتر عددی به عنوان سال ورودی می‌گیرند، مانند مقدار موجود در فایل CSV به صورت یک عدد دو رقمی است. 
+ در فایل اولیه پروژه بخشی از فایل CSV اصلی قرار داده شده است.

# آنچه باید آپلود کنید

تنها فایل `GameAnalyzer.java` را بدون زیپ کردن ارسال کنید:

```
GameAnalyzer.java
```

</div>