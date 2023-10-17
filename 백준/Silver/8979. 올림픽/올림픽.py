

country_count, pick_num = map(int, input().split())

class Country:
    def __init__(self, num: int, gold: int, silver: int, bronze: int):
        self.num = num
        self.gold = gold
        self.silver = silver
        self.bronze = bronze
        self.total = gold * 3 + silver * 2 + bronze * 1
        self.rank = 0

countries = []
for i in range(0, country_count):
    num, gold, silver, bronze = map(int, input().split())
    countries.append(Country(num, gold, silver, bronze))

sorted_countries = sorted(countries, key=lambda country: country.total)

rank = 0
cur_score = 0
for i in range(0, country_count):
    if cur_score < sorted_countries[i].total:
        rank += 1
        cur_score = sorted_countries[i].total
    sorted_countries[i].rank = rank

for i in range(0, country_count):
    if sorted_countries[i].num == pick_num:
        print(sorted_countries[i].rank)
