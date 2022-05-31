package org.amrvimag.bocateria.view;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JScrollPane;
import javax.swing.JViewport;

/**
 *
 * @author Adrian MRV. aka AMRV || Ansuz (org.amrv)
 */
public class TScrollPane extends JScrollPane implements MouseListener, MouseMotionListener {

    private Point mousePressPosition = null;
    private float scrollMultiplier = 1f;
    private long lastScroll = System.currentTimeMillis();
    private float deltaX = 0;
    private float deltaY = 0;

    public TScrollPane(Component cmpnt, int i, int i1) {
        super(cmpnt, i, i1);
        init();
    }

    public TScrollPane(Component cmpnt) {
        super(cmpnt);
        init();
    }

    public TScrollPane(int i, int i1) {
        super(i, i1);
        init();
    }

    public TScrollPane() {
        init();
    }

    @Override
    public void setViewport(JViewport viewport) {
        super.setViewport(viewport);
        viewport.addMouseListener(this);
        viewport.addMouseMotionListener(this);
    }

    private void init() {
        super.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        super.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_NEVER);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressPosition = new Point(e.getPoint());
        lastScroll = 0;
        super.getViewport().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
//        super.getViewport().setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.getViewport().setCursor(Cursor.getDefaultCursor());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point dragEventPoint = e.getPoint();
        JViewport viewport = (JViewport) super.getViewport().getParent();
        Point viewPos = viewport.getViewPosition();
        int maxViewPosX = super.getViewport().getWidth() - viewport.getWidth();
        int maxViewPosY = super.getViewport().getHeight() - viewport.getHeight();

        if (super.getViewport().getWidth() > viewport.getWidth()) {
            viewPos.x -= dragEventPoint.x - mousePressPosition.x;

            if (viewPos.x < 0) {
                viewPos.x = 0;
                mousePressPosition.x = dragEventPoint.x;
            }

            if (viewPos.x > maxViewPosX) {
                viewPos.x = maxViewPosX;
                mousePressPosition.x = dragEventPoint.x;
            }
        }

        if (super.getViewport().getHeight() > viewport.getHeight()) {
            viewPos.y -= dragEventPoint.y - mousePressPosition.y;

            if (viewPos.y < 0) {
                viewPos.y = 0;
                mousePressPosition.y = dragEventPoint.y;
            }

            if (viewPos.y > maxViewPosY) {
                viewPos.y = maxViewPosY;
                mousePressPosition.y = dragEventPoint.y;
            }
        }

        viewport.setViewPosition(viewPos);
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
