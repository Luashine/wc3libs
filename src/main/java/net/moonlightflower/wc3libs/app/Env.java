package net.moonlightflower.wc3libs.app;

import net.moonlightflower.wc3libs.bin.app.MMP;
import net.moonlightflower.wc3libs.bin.app.SHD;
import net.moonlightflower.wc3libs.bin.app.W3E;
import net.moonlightflower.wc3libs.bin.app.WPM;
import net.moonlightflower.wc3libs.dataTypes.app.Bounds;
import net.moonlightflower.wc3libs.dataTypes.app.Coords2DF;
import net.moonlightflower.wc3libs.misc.PathMap;
import net.moonlightflower.wc3libs.misc.ShadowMap;

import javax.annotation.Nonnull;

public class Env {
	private SHD _shd;

	@Nonnull
	public SHD getSHD() {
		return _shd;
	}

	private W3E _w3e;

	@Nonnull
	public W3E getW3E() {
		return _w3e;
	}

	private WPM _wpm;

	@Nonnull
	public WPM getWPM() {
		return _wpm;
	}

	private MMP _mmp;

	@Nonnull
	public MMP getMMP() {
		return _mmp;
	}
	
	public int getWidth() {
		return _w3e.getWidth();
	}
	
	public int getHeight() {
		return _w3e.getHeight();
	}
	
	public void setBounds(@Nonnull Bounds val) {
		_shd.setBounds(val, true);
		_w3e.setBounds(val, true, true);
		_wpm.setBounds(val, true, true);
	}
	
	public boolean getShadow(@Nonnull Coords2DF pos) {
		return _shd.getShadowMap().getByPos(pos);
	}
	
	public void setShadow(@Nonnull Coords2DF pos, boolean val) {
		_shd.getShadowMap().setByPos(pos, val);
	}
	
	public Env(@Nonnull W3E w3e, @Nonnull SHD shd, @Nonnull WPM wpm, @Nonnull MMP mmp) {
		_mmp = mmp;
		_shd = shd;
		_w3e = w3e;
		_wpm = wpm;

		_shd.setBounds(_w3e.getBounds().scale(W3E.CELL_SIZE / ShadowMap.CELL_SIZE), true);
		_wpm.setBounds(_w3e.getBounds().scale(W3E.CELL_SIZE / PathMap.CELL_SIZE), true, true);
	}
	
	public Env(@Nonnull Bounds bounds) {
		this(new W3E(bounds), new SHD(bounds), new WPM(bounds), new MMP());
	}
}
