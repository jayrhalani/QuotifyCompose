package com.jayhalani.quotifycompose.data

data class QuoteModel(
    val id: Int,
    val text: String,
    val author: String,
    val category: QuoteCategory,
    val avatar: String = "👤"
)

enum class QuoteCategory {
    ALL, LIFE, SUCCESS, MOTIVATION, LOVE, WISDOM, HUMOR, COURAGE, LEADERSHIP, EDUCATION, PHILOSOPHY
}

object QuoteData {
    fun getQuotes(): List<QuoteModel> = listOf(

        // --- LIFE (1–15)
        QuoteModel(1, "Life is really simple, but we insist on making it complicated.", "Confucius", QuoteCategory.LIFE),
        QuoteModel(2, "The purpose of our lives is to be happy.", "Dalai Lama", QuoteCategory.LIFE),
        QuoteModel(
            3,
            "In three words I can sum up everything I've learned about life: it goes on.",
            "Robert Frost",
            QuoteCategory.LIFE
        ),
        QuoteModel(4, "Life is what happens when you're busy making other plans.", "John Lennon", QuoteCategory.LIFE),
        QuoteModel(
            5,
            "Keep your face always toward the sunshine—and shadows will fall behind you.",
            "Walt Whitman",
            QuoteCategory.LIFE
        ),
        QuoteModel(6, "The unexamined life is not worth living.", "Socrates", QuoteCategory.LIFE),
        QuoteModel(7, "Life is either a daring adventure or nothing at all.", "Helen Keller", QuoteCategory.LIFE),
        QuoteModel(
            8,
            "To live is the rarest thing in the world. Most people exist, that is all.",
            "Oscar Wilde",
            QuoteCategory.LIFE
        ),
        QuoteModel(9, "Turn your wounds into wisdom.", "Oprah Winfrey", QuoteCategory.LIFE),
        QuoteModel(10, "Life shrinks or expands in proportion to one’s courage.", "Anaïs Nin", QuoteCategory.LIFE),
        QuoteModel(11, "Do not let making a living prevent you from making a life.", "John Wooden", QuoteCategory.LIFE),
        QuoteModel(
            12,
            "Life isn’t about finding yourself. It’s about creating yourself.",
            "George Bernard Shaw",
            QuoteCategory.LIFE
        ),
        QuoteModel(
            13,
            "Live as if you were to die tomorrow. Learn as if you were to live forever.",
            "Mahatma Gandhi",
            QuoteCategory.LIFE
        ),
        QuoteModel(14, "Act as if what you do makes a difference. It does.", "William James", QuoteCategory.LIFE),
        QuoteModel(15, "Life is a long lesson in humility.", "James M. Barrie", QuoteCategory.LIFE),

        // --- SUCCESS (16–30)
        QuoteModel(
            16,
            "Success usually comes to those who are too busy to be looking for it.",
            "Henry David Thoreau",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(
            17,
            "Don't be afraid to give up the good to go for the great.",
            "John D. Rockefeller",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(
            18,
            "Success is not final; failure is not fatal: it is the courage to continue that counts.",
            "Winston Churchill",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(
            19,
            "The only place where success comes before work is in the dictionary.",
            "Vidal Sassoon",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(
            20,
            "The way to get started is to quit talking and begin doing.",
            "Walt Disney",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(
            21,
            "I find that the harder I work, the more luck I seem to have.",
            "Thomas Jefferson",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(22, "Opportunities don't happen. You create them.", "Chris Grosser", QuoteCategory.SUCCESS),
        QuoteModel(
            23,
            "Success is walking from failure to failure with no loss of enthusiasm.",
            "Winston Churchill",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(24, "Don’t let yesterday take up too much of today.", "Will Rogers", QuoteCategory.SUCCESS),
        QuoteModel(
            25,
            "What you do speaks so loudly that I cannot hear what you say.",
            "Ralph Waldo Emerson",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(26, "A goal is a dream with a deadline.", "Napoleon Hill", QuoteCategory.SUCCESS),
        QuoteModel(
            27,
            "If you really look closely, most overnight successes took a long time.",
            "Steve Jobs",
            QuoteCategory.SUCCESS
        ),
        QuoteModel(28, "The secret of getting ahead is getting started.", "Mark Twain", QuoteCategory.SUCCESS),
        QuoteModel(29, "Fall seven times and stand up eight.", "Japanese Proverb", QuoteCategory.SUCCESS),
        QuoteModel(30, "Action is the foundational key to all success.", "Pablo Picasso", QuoteCategory.SUCCESS),

        // --- MOTIVATION (31–45)
        QuoteModel(
            31,
            "It does not matter how slowly you go as long as you do not stop.",
            "Confucius",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(32, "Everything you can imagine is real.", "Pablo Picasso", QuoteCategory.MOTIVATION),
        QuoteModel(33, "You miss 100% of the shots you don't take.", "Wayne Gretzky", QuoteCategory.MOTIVATION),
        QuoteModel(
            34,
            "Whether you think you can or you think you can't, you're right.",
            "Henry Ford",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(
            35,
            "The future belongs to those who believe in the beauty of their dreams.",
            "Eleanor Roosevelt",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(36, "Dream big and dare to fail.", "Norman Vaughan", QuoteCategory.MOTIVATION),
        QuoteModel(37, "Everything has beauty, but not everyone sees it.", "Confucius", QuoteCategory.MOTIVATION),
        QuoteModel(
            38,
            "The only limit to our realization of tomorrow is our doubts of today.",
            "Franklin D. Roosevelt",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(39, "Hard times create strong men.", "G. Michael Hopf", QuoteCategory.MOTIVATION),
        QuoteModel(40, "What we think, we become.", "Buddha", QuoteCategory.MOTIVATION),
        QuoteModel(
            41,
            "If you want to lift yourself up, lift up someone else.",
            "Booker T. Washington",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(
            42,
            "Great things are done by a series of small things brought together.",
            "Vincent van Gogh",
            QuoteCategory.MOTIVATION
        ),
        QuoteModel(43, "The best way out is always through.", "Robert Frost", QuoteCategory.MOTIVATION),
        QuoteModel(44, "Start where you are. Use what you have. Do what you can.", "Arthur Ashe", QuoteCategory.MOTIVATION),
        QuoteModel(45, "Don’t watch the clock; do what it does. Keep going.", "Sam Levenson", QuoteCategory.MOTIVATION),

        // --- LOVE (46–55)
        QuoteModel(46, "We accept the love we think we deserve.", "Stephen Chbosky", QuoteCategory.LOVE),
        QuoteModel(47, "Love all, trust a few, do wrong to none.", "William Shakespeare", QuoteCategory.LOVE),
        QuoteModel(48, "Where there is love there is life.", "Mahatma Gandhi", QuoteCategory.LOVE),
        QuoteModel(49, "Love is composed of a single soul inhabiting two bodies.", "Aristotle", QuoteCategory.LOVE),
        QuoteModel(
            50,
            "The supreme happiness of life is the conviction that we are loved.",
            "Victor Hugo",
            QuoteCategory.LOVE
        ),
        QuoteModel(51, "To love and be loved is to feel the sun from both sides.", "David Viscott", QuoteCategory.LOVE),
        QuoteModel(52, "Love recognizes no barriers.", "Maya Angelou", QuoteCategory.LOVE),
        QuoteModel(53, "There is only one happiness in this life, to love and be loved.", "George Sand", QuoteCategory.LOVE),
        QuoteModel(54, "If you judge people, you have no time to love them.", "Mother Teresa", QuoteCategory.LOVE),
        QuoteModel(
            55,
            "Being deeply loved gives you strength; loving deeply gives you courage.",
            "Lao Tzu",
            QuoteCategory.LOVE
        ),

        // --- WISDOM (56–70)
        QuoteModel(56, "Knowing yourself is the beginning of all wisdom.", "Aristotle", QuoteCategory.WISDOM),
        QuoteModel(57, "The only true wisdom is in knowing you know nothing.", "Socrates", QuoteCategory.WISDOM),
        QuoteModel(
            58,
            "Wise men speak because they have something to say; fools because they have to say something.",
            "Plato",
            QuoteCategory.WISDOM
        ),
        QuoteModel(59, "Do what you can, with what you have, where you are.", "Theodore Roosevelt", QuoteCategory.WISDOM),
        QuoteModel(60, "The journey of a thousand miles begins with one step.", "Lao Tzu", QuoteCategory.WISDOM),
        QuoteModel(
            61,
            "Education is not the filling of a pail, but the lighting of a fire.",
            "William Butler Yeats",
            QuoteCategory.WISDOM
        ),
        QuoteModel(62, "Honesty is the first chapter in the book of wisdom.", "Thomas Jefferson", QuoteCategory.WISDOM),
        QuoteModel(63, "The quieter you become, the more you can hear.", "Ram Dass", QuoteCategory.WISDOM),
        QuoteModel(64, "He who knows, does not speak. He who speaks, does not know.", "Lao Tzu", QuoteCategory.WISDOM),
        QuoteModel(65, "The greatest wealth is to live content with little.", "Plato", QuoteCategory.WISDOM),
        QuoteModel(66, "What you seek is seeking you.", "Rumi", QuoteCategory.WISDOM),
        QuoteModel(67, "The mind is everything. What you think you become.", "Buddha", QuoteCategory.WISDOM),
        QuoteModel(68, "Silence is a source of great strength.", "Lao Tzu", QuoteCategory.WISDOM),
        QuoteModel(69, "It is not the mountain we conquer but ourselves.", "Edmund Hillary", QuoteCategory.WISDOM),
        QuoteModel(70, "Patience is bitter, but its fruit is sweet.", "Aristotle", QuoteCategory.WISDOM),

        // --- HUMOR (71–80)
        QuoteModel(71, "I can resist everything except temptation.", "Oscar Wilde", QuoteCategory.HUMOR),
        QuoteModel(72, "People say nothing is impossible, but I do nothing every day.", "A. A. Milne", QuoteCategory.HUMOR),
        QuoteModel(
            73,
            "I am so clever that sometimes I don't understand a single word of what I am saying.",
            "Oscar Wilde",
            QuoteCategory.HUMOR
        ),
        QuoteModel(74, "A day without sunshine is like, you know, night.", "Steve Martin", QuoteCategory.HUMOR),
        QuoteModel(75, "Get your facts first, then you can distort them as you please.", "Mark Twain", QuoteCategory.HUMOR),
        QuoteModel(76, "I refuse to join any club that would have me as a member.", "Groucho Marx", QuoteCategory.HUMOR),
        QuoteModel(77, "Behind every great man is a woman rolling her eyes.", "Jim Carrey", QuoteCategory.HUMOR),
        QuoteModel(78, "If you think nobody cares, try missing a couple of payments.", "Steven Wright", QuoteCategory.HUMOR),
        QuoteModel(
            79,
            "The road to success is dotted with many tempting parking spaces.",
            "Will Rogers",
            QuoteCategory.HUMOR
        ),
        QuoteModel(80, "My life needs editing.", "Mort Sahl", QuoteCategory.HUMOR),

        // --- COURAGE (81–90)
        QuoteModel(81, "Courage is grace under pressure.", "Ernest Hemingway", QuoteCategory.COURAGE),
        QuoteModel(82, "Fortune favors the brave.", "Virgil", QuoteCategory.COURAGE),
        QuoteModel(
            83,
            "You cannot swim for new horizons until you have courage to lose sight of the shore.",
            "William Faulkner",
            QuoteCategory.COURAGE
        ),
        QuoteModel(
            84,
            "Courage is not the absence of fear, but the triumph over it.",
            "Nelson Mandela",
            QuoteCategory.COURAGE
        ),
        QuoteModel(
            85,
            "He who is not courageous enough to take risks will accomplish nothing in life.",
            "Muhammad Ali",
            QuoteCategory.COURAGE
        ),
        QuoteModel(
            86,
            "It takes courage to grow up and become who you really are.",
            "E. E. Cummings",
            QuoteCategory.COURAGE
        ),
        QuoteModel(87, "Without courage, wisdom bears no fruit.", "Baltasar Gracián", QuoteCategory.COURAGE),
        QuoteModel(88, "Leap and the net will appear.", "John Burroughs", QuoteCategory.COURAGE),
        QuoteModel(
            89,
            "Do the thing you fear, and the death of fear is certain.",
            "Ralph Waldo Emerson",
            QuoteCategory.COURAGE
        ),
        QuoteModel(
            90,
            "Only those who dare to fail greatly can ever achieve greatly.",
            "Robert F. Kennedy",
            QuoteCategory.COURAGE
        ),

        // --- LEADERSHIP / PHILOSOPHY / EDUCATION (91–100)
        QuoteModel(91, "The price of greatness is responsibility.", "Winston Churchill", QuoteCategory.LEADERSHIP),
        QuoteModel(
            92,
            "A leader is one who knows the way, goes the way, and shows the way.",
            "John C. Maxwell",
            QuoteCategory.LEADERSHIP
        ),
        QuoteModel(
            93,
            "Example is not the main thing in influencing others. It is the only thing.",
            "Albert Schweitzer",
            QuoteCategory.LEADERSHIP
        ),
        QuoteModel(
            94,
            "The greatest leader is not necessarily the one who does the greatest things. He is the one that gets people to do the greatest things.",
            "Ronald Reagan",
            QuoteCategory.LEADERSHIP
        ),
        QuoteModel(
            95,
            "Education is the most powerful weapon which you can use to change the world.",
            "Nelson Mandela",
            QuoteCategory.EDUCATION
        ),
        QuoteModel(96, "The roots of education are bitter, but the fruit is sweet.", "Aristotle", QuoteCategory.EDUCATION),
        QuoteModel(97, "An investment in knowledge pays the best interest.", "Benjamin Franklin", QuoteCategory.EDUCATION),
        QuoteModel(
            98,
            "We are what we repeatedly do. Excellence, then, is not an act but a habit.",
            "Aristotle",
            QuoteCategory.PHILOSOPHY
        ),
        QuoteModel(99, "Happiness depends upon ourselves.", "Aristotle", QuoteCategory.PHILOSOPHY),
        QuoteModel(100, "Man is condemned to be free.", "Jean-Paul Sartre", QuoteCategory.PHILOSOPHY),
    )
}
