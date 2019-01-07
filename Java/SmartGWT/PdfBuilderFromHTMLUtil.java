
/**
 *
 * @author Peyman Ekhtiar
 *
 */

import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.html.simpleparser.StyleSheet;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPRow;
import com.lowagie.text.pdf.PdfPTable;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PdfBuilderFromHTMLUtil {

	private void setFontToChunkOfPdfTable(PdfPTable element, Font font){
		Object[] rows = element.getRows().toArray();
		for (Object row: rows){
			if (row instanceof PdfPRow) {
				Object[] cells = ((PdfPRow) row).getCells();
				for (Object cell: cells) {
				    if (cell instanceof PdfPCell) {
                        LinkedList<Paragraph> paragraphs = (LinkedList<Paragraph>) ((PdfPCell) cell).getCompositeElements();
                        for (Paragraph paragraph : paragraphs) {
                            setFontToChunks(paragraph.getChunks(), font);
                        }
                    }
				}
			}
		}
	}
	private void setFontToChunks(ArrayList<Chunk> chunk, Font font){
		for (int l = 0; l < chunk.size(); l++)
		{
			Font _original_chunk_font = chunk.get(l).getFont();
			Font _newchunk_font = new Font(font);

			_newchunk_font.setFamily(_original_chunk_font.getFamilyname());
			_newchunk_font.setStyle(_original_chunk_font.getStyle());
			_newchunk_font.setSize(_original_chunk_font.getSize());
			_newchunk_font.setColor(_original_chunk_font.getColor());

			chunk.get(l).setFont(_newchunk_font);
		}
	}

	public void PdfBuilder (String html, Font font, Paragraph p ) throws IOException {
		List<Element> list = HTMLWorker.parseToList(new StringReader(html), new StyleSheet());
		for (Element element : list) {
			if (element instanceof PdfPTable) {
				setFontToChunkOfPdfTable((PdfPTable) element, font);
			} else {
				setFontToChunks(element.getChunks(), font);
			}
			p.add(element);
		}
	}
	
}
