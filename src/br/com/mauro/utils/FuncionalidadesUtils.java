package br.com.mauro.utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.mauro.view.IndexView;

public class FuncionalidadesUtils implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Calendar calendar = Calendar.getInstance();
		IndexView.data = String.format("%1$tH:%1$tM:%1$tS", calendar);
	}

	public String FuncLogado() {
		
		
		return null;
	}

	
	public void DataHoraAtual() {
			
	Thread dataHora = new Thread(){
		public void run() {
			try {
				for(;;) {
				Calendar calendar = new GregorianCalendar();
				int dia = calendar.get(Calendar.DAY_OF_MONTH);
				int mes = calendar.get(Calendar.MONTH);
				int ano = calendar.get(Calendar.YEAR);
				
				int horas = calendar.get(Calendar.HOUR);
				int minutos = calendar.get(Calendar.MINUTE);
				int segundos = calendar.get(Calendar.SECOND);
				
				IndexView.data = ("Data: "+dia+"/"+mes+"/"+ano+" \n"+horas+":"+minutos+":"+segundos);
				
				
				sleep(1000);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			  }
		}
	};
	dataHora.start();
	
  }
	
	/**
	 * @author Mauro Degaspari
	 * @return O Valor relacionado a linha do JTable tbClientes, caso não 
	 * 		   tenha valor retorne uma String " ". 
	 */
	public String trantandoValor(JTable table, int row, int column) {
		Object linha = table.getValueAt(row, column);
		return linha != null ? linha.toString() : "";
		
	}
	
	public double TotalCompra( double preco,int qtd) {
		
		double  subtotal, total = 0;
		
				
		subtotal = (qtd * preco);
		
		total += subtotal;
		
		
	
		return total;
	}
}


