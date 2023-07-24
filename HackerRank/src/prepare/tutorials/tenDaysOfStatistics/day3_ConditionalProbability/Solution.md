貝氏定理 (Bayes' theorem)
(參考：https://www.hackerrank.com/challenges/s10-mcq-4/editorial)
>`兩個孩子中至少有一個是男孩的概率為：P(B) = P(BB)+P(BG)+P(GB) = 1/4 + 1/4 + 1/4 = 3/4`
>`兩個孩子中有兩個是男孩的概率是：P(BB) = P(B)*P(B)=1/2 * 1/2 = 1/4`
>`P(BB|B) = P(B|BB)*P(BB) / P(B) = 1*(1/4) /(3/4) = (1/4) / (3/4) = 1/3`
>>`也可以換個方式理解，原本P(BB)=P(BG)+P(GB)=P(GG)=1/4，但當其中一個已確認為男，則條件要去掉GG的可能；全部剩下三種可能，而要BB只佔其中一種可能，所以就是1/3`