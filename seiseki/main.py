from functools import reduce

DIGITS = 5

ret = []
while True:
	try:
		student = list(map(int, input().split()))
	except EOFError:
		break

	if len(student) == 0:
		break

	# 理科から得点の低い2科目を0点扱いにする
	science = student[4:8]
	zeros = list(filter(lambda v: v == 0, science))
	for _ in range(2 - len(zeros)):
		science[science.index(min(science, key=lambda n: float("inf") if n <= 0 else n))] = 0
	filtered = student[:4] + science
	# 合計点を求める
	s = reduce(lambda p, c: p + c, filtered[1:])
	# ソートにかける配列に1人分のデータを追加
	ret.append(filtered + [s])

# 合計点で降順にソート
grades = sorted(ret, key=lambda student: student[8], reverse=True)
# 得点のデータに順位を追加
rank = 1
for i, student in enumerate(grades):
	if i >= 1:
		prev = grades[i - 1]
		# 1つ前の人より合計点が低ければ(インデックス + 1)を、そうでなければ前の人と同順位
		rank = i + 1 if prev[8] > student[8] else rank
	student.append(rank)

# 列ラベルを表示
print("".join(map(lambda label: label.rjust(DIGITS, " "), ["ID", "m2b", "m3b", "eng", "phy", "che", "bio", "geo", "sum", "rank"])))
# データを整形して表示
for student in grades:
	print("".join(map(lambda n: str(n).rjust(DIGITS, " "), student)))
