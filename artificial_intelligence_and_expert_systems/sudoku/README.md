<div dir="rtl" style="font-family: Vazirmatn; word-break: initial">

شما در این سوال باید به کمک الگوریتم‌های CSP برنامه‌ای بنویسید تا یک مسئله‌ی سودوکو را حل کند.

<div  class="d-flex justify-center">
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Sudoku_Puzzle_by_L2G-20050714_standardized_layout.svg/1200px-Sudoku_Puzzle_by_L2G-20050714_standardized_layout.svg.png" width=300 height=300>

</div>

# پیاده‌سازی

برای پیاده‌سازی شما باید یک فایل با نام `sudoku.py` ایجاد کنید. در این فایل یک تابع با امضای زیر وجود دارد که صفحه سودوکو را ورودی می‌گیرد و حل شده‌ی آن را خروجی می‌دهد.

</div>


```python sudoku.py
def solver(board: list[list]) -> list[list]:
	pass
```

<div dir="rtl" style="font-family: Vazirmatn; word-break: initial">


# ورودی

به برنامه یک آرایه دو بعدی که تعیین کننده‌ی مقادیر هر خانه از جدول سودوکو است، داده خواهد شد. اندازه هر سودوکو بین `3x3` و `9x9` خواهد بود.

اندازه سودوکو تعیین کننده‌ی مقادیر مجاز هر خانه است. به طور مثال اگر سودوکو `9x9` باشد، مقدار هر خانه عددی بین 0 تا 9 خواهد بود. عدد 0 به معنای خالی بودن آن خانه است که باید توسط برنامه شما مقدار صحیح آن پیدا شود.

# خروجی

اگر سودوکو جواب داشته باشد، خروجی یک سودوکو حل شده به صورت آرایه‌ای دو بعدی است. در غیر این صورت تابع `solver` مقدار `None` بر می‌گرداند.

# مثال

## نمونه ورودی

</div>


```
[
	[0, 3, 0, 4], 
	[0, 1, 0, 0], 
	[0, 0, 0, 3], 
	[3, 0, 4, 0]
]
```

<div dir="rtl" style="font-family: Vazirmatn; word-break: initial">

## نمونه خروجی

</div>


```
[
	[1, 3, 2, 4],
	[4, 1, 3, 2],
	[2, 4, 1, 3],
	[3, 2, 4, 1]
]
```

<div dir="rtl" style="font-family: Vazirmatn; word-break: initial">


# نکات

- سودوکوها با اندازه‌ی مربعی هستند.
- مسئله یک جواب ندارد.
- + برای مطالعه بیشتر به chapter5 کتاب مراجعه کنید.

# آنچه باید آپلود کنید

ساختار فایل `zip` ارسالی باید به صورت زیر باشد:
</div>



```
<zip_file_name.zip>
	└── sudoku.py
```