package order


import com.itextpdf.text.*
import com.itextpdf.text.pdf.PdfWriter
import org.dom4j.DocumentException
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper

import javax.mail.MessagingException
import javax.mail.internet.MimeMessage

class PdfFileSender
{
    private JavaMailSender mailSender

    void sendPdfFile(String emailAddress, Order order) throws FileNotFoundException, DocumentException, MessagingException
    {
        String filename = order.getNumber() + ".pdf"

        Document document = new Document()
        PdfWriter.getInstance(document, new FileOutputStream(filename))

        document.open()
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK)

        prepareInvoiceContent(document, font, order)
        document.close()

        MimeMessage message = mailSender.createMimeMessage()
        MimeMessageHelper helper = new MimeMessageHelper(message, true)
        helper.setTo(emailAddress)
        helper.setSubject(("Invoice " + order.getNumber()))
        helper.setText(String.format(
                "Hello! Invoice for your order with number: %s can be found in email's attachments",
                order.getNumber())
        )
        helper.addAttachment(filename, new File(filename))

        mailSender.send(message)
    }

    private void prepareInvoiceContent(Document document, Font font, Order order) throws DocumentException
    {
        document.add(new Paragraph("Invoice number " + order.getNumber(), font))
        document.add(new Paragraph(""))
        document.add(new Paragraph(""))
        document.add(new Paragraph("Line item: ", font))
        document.add(new Paragraph(""))
        document.add(new Paragraph(order.getOrderItem().getProduct().getName(), font))
        document.add(new Paragraph(""))
        document.add(new Paragraph(""))
        document.add(new Paragraph("Total price: " + order.getOrderItem().getProduct().getPrice(), font))
        document.add(new Paragraph(""))
        document.add(new Paragraph(""))
        document.add(new Paragraph("Thank you for shopping with us!", font))
    }

    void setMailSender(JavaMailSender mailSender)
    {
        this.mailSender = mailSender
    }
}
