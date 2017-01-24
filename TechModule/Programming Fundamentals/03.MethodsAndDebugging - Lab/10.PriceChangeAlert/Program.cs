using System;

class PriceChangeAlert
{
    static void Main()
    {
        int n = int.Parse(Console.ReadLine());
        double limit = double.Parse(Console.ReadLine());
        double lastPrice = double.Parse(Console.ReadLine());

        for (int i = 0; i < n - 1; i++)
        {
            double currentPrice = double.Parse(Console.ReadLine());
            double percentChange = GetPercentChange(lastPrice, currentPrice);
            bool isSignificantDifference = GetSignificance(percentChange, limit);
            string message = GetMessage(currentPrice, lastPrice, percentChange, isSignificantDifference);
            Console.WriteLine(message);
            lastPrice = currentPrice;
        }
    }

    private static string GetMessage(double currentPrice, double lastPrice, double difference, bool isSignificanDifference)
    {
        string message = "";
        if (difference == 0)
        {
            message = string.Format("NO CHANGE: {0}", currentPrice);
        }
        else if (!isSignificanDifference)
        {
            message = string.Format("MINOR CHANGE: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);
        }
        else if (isSignificanDifference && (difference > 0))
        {
            message = string.Format("PRICE UP: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);
        }
        else if (isSignificanDifference && (difference < 0))
            message = string.Format("PRICE DOWN: {0} to {1} ({2:F2}%)", lastPrice, currentPrice, difference);
        return message;
    }

    private static bool GetSignificance(double percentChange, double limit)
    {
        if (Math.Abs(percentChange) >= limit * 100)
        {
            return true;
        }
        return false;
    }

    private static double GetPercentChange(double lastPrice, double currentPrice)
    {
        double result = (currentPrice - lastPrice) / lastPrice;
        return result * 100;
    }
}
