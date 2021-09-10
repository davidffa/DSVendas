import { SaleSum } from 'types/sale';
import axios from 'axios';
import Chart from 'react-apexcharts';
import { BASE_URL } from 'utils/requests';
import { useEffect, useState } from 'react';

type ChartData = {
  labels: string[];
  series: number[];
}

const DonutChart = () => {
  const [chartData, setChartData] = useState<ChartData>({ labels: [], series: [] });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/amount-by-seller`).then(res => {
      const data = res.data as SaleSum[];

      const labels = data.map(x => x.sellerName);
      const series = data.map(x => x.sum);

      setChartData({ labels, series });
    });
  }, []);

  const options = {
    legend: {
      show: true
    }
  }

  return (
    <Chart
      options={{ ...options, labels: chartData.labels }}
      series={chartData.series}
      type="donut"
      height="240"
    />
  );
}

export default DonutChart;