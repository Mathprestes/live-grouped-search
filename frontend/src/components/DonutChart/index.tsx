import axios from 'axios';
import { useEffect } from 'react';
import { useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleByStore } from 'types/sale';

type ChartData = {
    labels: string[];
    series: number[];
};

const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ 
        labels: [], 
        series: [],
     });

    useEffect(() => {

        axios.get("http://localhost:8080/sales/by-store")
        .then((response) => {

            const data = response.data as SaleByStore[];
            const myLabels = data.map(x => x.storeName); //montando uma lista so com os nome
            const mySeries = data.map(x => x.sum); //montando uma lista so com os totais

            //a lista no postman vem em pares, que seria o nome da loja e seu respectivo total
            //para poder exibir no grafico de pizza temos que fazer duas listas separadas e nao uma lista em pares (nome e total)
            //para poder exibir no grafico de pizza

            setChartData({
                series: mySeries,
                labels: myLabels
            })
        });
    }, []);

    const options = {
        legend: {
            show: true
        }
    };

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